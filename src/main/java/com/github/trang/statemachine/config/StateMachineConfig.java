package com.github.trang.statemachine.config;

import com.github.trang.statemachine.model.enums.Events;
import com.github.trang.statemachine.model.enums.States;
import com.github.trang.statemachine.persist.Persist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.recipes.persist.PersistStateMachineHandler;
import org.springframework.statemachine.state.State;

import java.util.Objects;
import java.util.Optional;

/**
 * @author trang
 */
@Configuration
@Slf4j
public class StateMachineConfig {

    @Configuration
    @EnableStateMachine
    static class PersistStateMachineConfig extends StateMachineConfigurerAdapter<String, String> {

        /**
         * 定义可处理的状态
         */
        @Override
        public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
            states.withStates()
                    // 定义初始状态
                    .initial(States.VALID)
                    // 定义结束状态，状态机不能由此状态流转到其它状态
                    .end(States.INVALID)
                    // 定义全部状态
                    .states(States.all());
        }

        /**
         * 定义状态流转
         */
        @Override
        public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
            transitions
                    .withExternal().event(Events.INTENTION).source(States.VALID).target(States.DRAFT_INTENTION)
                    .and()
                    .withExternal().event(Events.PAY).source(States.DRAFT_INTENTION).target(States.DRAFT_EARNEST)
                    .and()
                    .withExternal().event(Events.CONTRACT).source(States.DRAFT_EARNEST).target(States.DRAFT)
                    .and()
                    .withExternal().event(Events.TRANSFER).source(States.DRAFT).target(States.TRANSFER);
        }

        @Override
        public void configure(StateMachineConfigurationConfigurer<String, String> config) throws Exception {
            config.withConfiguration()
                    .machineId("state-machine-test")
                    .autoStartup(true)
                    .listener(new GlobalStateMachineListener());
        }
    }

    static class GlobalStateMachineListener extends StateMachineListenerAdapter<String, String> {
        @Override
        public void stateChanged(State<String, String> from, State<String, String> to) {
            Optional.ofNullable(from)
                    .filter(Objects::nonNull)
                    .ifPresent((f) -> log.info("房源状态从: {} 流转到: {}", f.getId(), to.getId()));
        }

        @Override
        public void stateMachineError(StateMachine<String, String> stateMachine, Exception e) {
            log.error("状态机异常: {}", stateMachine, e);
        }
    }

    @Configuration
    static class PersistHandlerConfig {

        @Bean
        public PersistStateMachineHandler persistStateMachineHandler(StateMachine<String, String> stateMachine) {
            return new PersistStateMachineHandler(stateMachine);
        }

        @Bean
        public Persist persist(PersistStateMachineHandler handler) {
            return new Persist(handler);
        }
    }

}

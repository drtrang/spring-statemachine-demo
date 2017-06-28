package com.github.trang.statemachine.annotation;

import com.github.trang.statemachine.model.enums.EnumHousedelStatus;
import org.springframework.statemachine.annotation.OnTransition;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author trang
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OnTransition
public @interface StatesOnTransition {

    EnumHousedelStatus[] source() default {};

    EnumHousedelStatus[] target() default {};

}
package com.github.trang.statemachine.model.enums;

import java.util.*;

/**
 * 房源状态包装类，必须与 #{@link EnumHousedelStatus} 保持一致
 *
 * @author trang
 */
public class States {

    // 有效
    public static final String VALID = "VALID";
    private static final String _VALID = EnumHousedelStatus.VALID.state();
    // 意向金起草
    public static final String DRAFT_INTENTION = "DRAFT_INTENTION";
    private static final String _DRAFT_INTENTION = EnumHousedelStatus.DRAFT_INTENTION.state();
    // 意向金盖章
    public static final String SEAL_INTENTION = "SEAL_INTENTION";
    private static final String _SEAL_INTENTION = EnumHousedelStatus.SEAL_INTENTION.state();
    // 意向金签订
    public static final String SIGN_INTENTION = "SIGN_INTENTION";
    private static final String _SIGN_INTENTION = EnumHousedelStatus.SIGN_INTENTION.state();
    // 定金起草
    public static final String DRAFT_EARNEST = "DRAFT_EARNEST";
    private static final String _DRAFT_EARNEST = EnumHousedelStatus.DRAFT_EARNEST.state();
    // 定金盖章
    public static final String SEAL_EARNEST = "SEAL_EARNEST";
    private static final String _SEAL_EARNEST = EnumHousedelStatus.SEAL_EARNEST.state();
    // 定金签订
    public static final String SIGN_EARNEST = "SIGN_EARNEST";
    private static final String _SIGN_EARNEST = EnumHousedelStatus.SIGN_EARNEST.state();
    // 定金转起草
    public static final String DEPOSIT_CONTRACT = "DEPOSIT_CONTRACT";
    private static final String _DEPOSIT_CONTRACT = EnumHousedelStatus.DEPOSIT_CONTRACT.state();
    // 合同起草
    public static final String DRAFT = "DRAFT";
    private static final String _DRAFT = EnumHousedelStatus.DRAFT.state();
    // 合同盖章
    public static final String SEAL = "SEAL";
    private static final String _SEAL = EnumHousedelStatus.SEAL.state();
    // 合同签订
    public static final String SIGN = "SIGN";
    private static final String _SIGN = EnumHousedelStatus.SIGN.state();
    // 过户
    public static final String TRANSFER = "TRANSFER";
    private static final String _TRANSFER = EnumHousedelStatus.TRANSFER.state();
    // 无效
    public static final String INVALID = "INVALID";
    private static final String _INVALID = EnumHousedelStatus.INVALID.state();

    private static final Set<String> STATE_SET = new HashSet<>();
    private static final Map<String, Integer> STATE_MAP = new HashMap<>();
    private static final Map<Integer, String> STATUS_MAP = new HashMap<>();
    static {
        Arrays.stream(EnumHousedelStatus.values()).forEach(e -> {
            STATE_SET.add(e.state());
            STATE_MAP.put(e.state(), e.status());
            STATUS_MAP.put(e.status(), e.state());
        });
    }

    public static Set<String> all() {
        return STATE_SET;
    }
    public static Integer findStatus(String state) {
        return STATE_MAP.get(state);
    }
    public static String findState(Integer status) {
        return STATUS_MAP.get(status);
    }

}
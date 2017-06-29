package com.github.trang.statemachine.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
@Accessors(fluent = true)
public enum EnumHousedelStatus {

    VALID(1, "VALID", "有效"),

    DRAFT_INTENTION(8, "DRAFT_INTENTION", "意向金起草"),
    SEAL_INTENTION(9, "SEAL_INTENTION", "意向金盖章"),
    SIGN_INTENTION(10, "SIGN_INTENTION", "意向金签订"),

    DRAFT_EARNEST(110, "DRAFT_EARNEST", "定金起草"),
    SEAL_EARNEST(12, "SEAL_EARNEST", "定金盖章"),
    SIGN_EARNEST(13, "SIGN_EARNEST", "定金签订"),

    DEPOSIT_CONTRACT(14, "DEPOSIT_CONTRACT", "定金转起草"),
    DRAFT(4, "DRAFT", "合同起草"),
    SEAL(5, "SEAL", "合同盖章"),
    SIGN(6, "SIGN", "合同签约"),

    TRANSFER(7, "TRANSFER", "过户"),
    INVALID(0, "INVALID", "无效");

    private static final Map<String, Integer> STATE_MAP = new HashMap<>();
    private static final Map<Integer, String> STATUS_MAP = new HashMap<>();

    static {
        Arrays.stream(values()).forEach(e -> {
            STATE_MAP.put(e.state(), e.status());
            STATUS_MAP.put(e.status(), e.state());
        });
    }

    private int status;
    private String state;
    private String desc;

    public static Integer findStatus(String state) {
        return STATE_MAP.get(state);
    }

    public static String findState(Integer status) {
        return STATUS_MAP.get(status);
    }

}
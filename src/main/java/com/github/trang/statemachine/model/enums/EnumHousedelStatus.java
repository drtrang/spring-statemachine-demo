package com.github.trang.statemachine.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Getter
public enum EnumHousedelStatus {

    VALID(1, "有效"),

    DRAFT_INTENTION(8, "意向金起草"),
    SEAL_INTENTION(9, "意向金盖章"),
    SIGN_INTENTION(10, "意向金签订"),

    DRAFT_EARNEST(110, "定金起草"),
    SEAL_EARNEST(12, "定金盖章"),
    SIGN_EARNEST(13, "定金签订"),

    DEPOSIT_CONTRACT(14, "定金转起草"),
    DRAFT(4, "合同起草"),
    SEAL(5, "合同盖章"),
    SIGN(6, "合同签约"),

    TRANSFER(7, "过户"),
    INVALID(0, "无效");


    private int value;
    private String desc;

    private static Map<Integer, EnumHousedelStatus> map = new HashMap<>();
    static {
        Arrays.stream(values()).forEach(e -> map.put(e.getValue(), e));
    }

    public static EnumHousedelStatus findByValue(int value) {
        return map.get(value);
    }

}
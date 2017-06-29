package com.github.trang.statemachine.model.enums;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author trang
 */
public class States {

    public static final String VALID = EnumHousedelStatus.VALID.getState();
    public static final String DRAFT_INTENTION = EnumHousedelStatus.DRAFT_INTENTION.getState();
    public static final String SEAL_INTENTION = EnumHousedelStatus.SEAL_INTENTION.getState();
    public static final String SIGN_INTENTION = EnumHousedelStatus.SIGN_INTENTION.getState();
    public static final String DRAFT_EARNEST = EnumHousedelStatus.DRAFT_EARNEST.getState();
    public static final String SEAL_EARNEST = EnumHousedelStatus.SEAL_EARNEST.getState();
    public static final String SIGN_EARNEST = EnumHousedelStatus.SIGN_EARNEST.getState();
    public static final String DEPOSIT_CONTRACT = EnumHousedelStatus.DEPOSIT_CONTRACT.getState();
    public static final String DRAFT = EnumHousedelStatus.DRAFT.getState();
    public static final String SEAL = EnumHousedelStatus.SEAL.getState();
    public static final String SIGN = EnumHousedelStatus.SIGN.getState();
    public static final String TRANSFER = EnumHousedelStatus.TRANSFER.getState();
    public static final String INVALID = EnumHousedelStatus.INVALID.getState();

    public static Set<String> all() {
        return Arrays.stream(EnumHousedelStatus.values())
                .map(EnumHousedelStatus::getState)
                .collect(Collectors.toSet());
    }

}
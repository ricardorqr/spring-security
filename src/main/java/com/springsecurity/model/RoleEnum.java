package com.springsecurity.model;

public enum RoleEnum {

    ADMIN("ADMIN"), DEV("DEV"), QA("QA");

    private final String value;

    RoleEnum(String value) {
        this.value = value;
    }

    public static RoleEnum fromValue(String value) {
        for (RoleEnum roleEnum : RoleEnum.values()) {
            if (roleEnum.value.equals(value)) {
                return roleEnum;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}



package com.springsecurity.model;

public enum RoleEnum {

    ADMIN(1, "ADMIN"),
    DEV(2, "DEV"),
    QA(3, "QA");

    private final Integer id;
    private final String value;

    RoleEnum(Integer id, String value) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}



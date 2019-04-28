package com.ta.framework.enums;

public enum UserEnum {
    ADMIN( 1 , "管理员"),
    TRADE_ADMIN( 2 , "商圈管理员"),
    STORE_ADMIN( 3 , "商铺管理员"),
    SIMPLE( 4 , "普通人员");


    private Integer code;
    private String name;

    UserEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

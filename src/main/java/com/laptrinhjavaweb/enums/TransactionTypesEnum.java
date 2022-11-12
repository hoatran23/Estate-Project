package com.laptrinhjavaweb.enums;

public enum TransactionTypesEnum {
    QTCSKH("QTCSKH", "QUÁ TRÌNH CHĂM SÓC KHÁCH HÀNG"),
    DDX("DDX", "DẪN ĐI XEM");
    private String code;
    private String value;

    TransactionTypesEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

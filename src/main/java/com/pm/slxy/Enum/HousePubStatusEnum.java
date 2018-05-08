package com.pm.slxy.Enum;

public enum HousePubStatusEnum {
    FREE("空闲"),
    IN_USE("在用");

    private String status;

    HousePubStatusEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

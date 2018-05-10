package com.pm.slxy.Enum;

public enum HouseApplyEnum {

    APPLY_ENUM("已被申请"),
    NOT_APPLY_ENUM("未被申请");

    private String status;

    HouseApplyEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.pm.slxy.Enum;

public enum HouseCzqkStatusEnum {


    APPROVAL_THROUGH("审核通过"),
    APPROVAL_THROUGH_NOT_THROUGH("审核不通过");

    private String status;

    HouseCzqkStatusEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.pm.slxy.Enum;

public enum  HouseCzqkZXTHouseStatusEnum {
    ZU_FANG("租房"),
    XUZU_FANG("续租"),
    TUI_FANG("退房");

    private String status;

    HouseCzqkZXTHouseStatusEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

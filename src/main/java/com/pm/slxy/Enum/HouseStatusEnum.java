package com.pm.slxy.Enum;

/**
 * @author furg@senthink.com
 * @date 2018/4/12
 */
public enum HouseStatusEnum {
    NOT_RENTAL("未租"),
    ALREADY_RENTAL("已租"),
    APPLY_RENTAL("续租"),
    CHECK_OUT_HOUSE("退房");

    private String status;

    HouseStatusEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

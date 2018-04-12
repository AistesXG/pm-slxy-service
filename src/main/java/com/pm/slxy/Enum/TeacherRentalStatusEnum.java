package com.pm.slxy.Enum;

/**
 * @author furg@senthink.com
 * @date 2018/4/12
 */
public enum TeacherRentalStatusEnum {
    NOT_RENTAL_HOUSE("未租房"),
    ALREADY_RENTAL_HOUSE("已租房");

    private String status;

    TeacherRentalStatusEnum(String status) {
        setStatus(status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

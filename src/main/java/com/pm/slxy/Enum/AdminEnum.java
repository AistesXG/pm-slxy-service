package com.pm.slxy.Enum;



/**
 * @author furg@senthink.com
 * @date 2018/4/12
 */
public enum AdminEnum {
    SYSTEM_ADMIN("系统管理员"),
    ORDINARY_ADMIN("普通管理员");

    private String role;


    AdminEnum(String role) {
        setRole(role);
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}

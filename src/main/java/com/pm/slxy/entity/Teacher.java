package com.pm.slxy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-26
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 教师姓名
     */
    private String teachername;
    /**
     * 教工编号
     */
    private String teachernumber;
    /**
     * 性别
     */
    private String teachersex;
    /**
     * 身份证号码
     */
    private String teacheridcard;
    /**
     * 出生年月
     */
    private String teacherbirthdate;
    /**
     * 学历
     */
    private String teachereducation;
    /**
     * 参加工作时间
     */
    private String teacherstartwork;
    /**
     * 申请住房日期
     */
    private String teacherhousingdate;
    /**
     * 所在部门
     */
    private String teacherdepartment;
    /**
     * 籍贯
     */
    private String teacherplaceorigin;
    /**
     * 租房状态
     */
    private String teacherrentalstatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }

    public String getTeachernumber() {
        return teachernumber;
    }

    public void setTeachernumber(String teachernumber) {
        this.teachernumber = teachernumber;
    }

    public String getTeachersex() {
        return teachersex;
    }

    public void setTeachersex(String teachersex) {
        this.teachersex = teachersex;
    }

    public String getTeacheridcard() {
        return teacheridcard;
    }

    public void setTeacheridcard(String teacheridcard) {
        this.teacheridcard = teacheridcard;
    }

    public String getTeacherbirthdate() {
        return teacherbirthdate;
    }

    public void setTeacherbirthdate(String teacherbirthdate) {
        this.teacherbirthdate = teacherbirthdate;
    }

    public String getTeachereducation() {
        return teachereducation;
    }

    public void setTeachereducation(String teachereducation) {
        this.teachereducation = teachereducation;
    }

    public String getTeacherstartwork() {
        return teacherstartwork;
    }

    public void setTeacherstartwork(String teacherstartwork) {
        this.teacherstartwork = teacherstartwork;
    }

    public String getTeacherhousingdate() {
        return teacherhousingdate;
    }

    public void setTeacherhousingdate(String teacherhousingdate) {
        this.teacherhousingdate = teacherhousingdate;
    }

    public String getTeacherdepartment() {
        return teacherdepartment;
    }

    public void setTeacherdepartment(String teacherdepartment) {
        this.teacherdepartment = teacherdepartment;
    }

    public String getTeacherplaceorigin() {
        return teacherplaceorigin;
    }

    public void setTeacherplaceorigin(String teacherplaceorigin) {
        this.teacherplaceorigin = teacherplaceorigin;
    }

    public String getTeacherrentalstatus() {
        return teacherrentalstatus;
    }

    public void setTeacherrentalstatus(String teacherrentalstatus) {
        this.teacherrentalstatus = teacherrentalstatus;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        ", id=" + id +
        ", teachername=" + teachername +
        ", teachernumber=" + teachernumber +
        ", teachersex=" + teachersex +
        ", teacheridcard=" + teacheridcard +
        ", teacherbirthdate=" + teacherbirthdate +
        ", teachereducation=" + teachereducation +
        ", teacherstartwork=" + teacherstartwork +
        ", teacherhousingdate=" + teacherhousingdate +
        ", teacherdepartment=" + teacherdepartment +
        ", teacherplaceorigin=" + teacherplaceorigin +
        ", teacherrentalstatus=" + teacherrentalstatus +
        "}";
    }
}

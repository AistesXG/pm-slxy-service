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
 * @since 2018-04-11
 */
public class HouseRentingSituation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 房间楼号
     */
    private String housefloornumber;
    /**
     * 房间编号
     */
    private String housenumber;
    /**
     * 申请租住日期
     */
    private String applycheckdate;
    /**
     * 租住年限
     */
    private Integer applytime;
    /**
     * 租住到期日期
     */
    private String applyexpiredate;
    /**
     * 房间租住类型
     */
    private String houserentaltype;
    /**
     * 房间面积
     */
    private Float housearea;
    /**
     * 特殊租住房间系数
     */
    private Float specialrentalhouse;
    /**
     * 是否属于双职工只租住一个房子
     */
    private String whetherdoubleone;
    /**
     * 是否带小孩
     */
    private String whetherchild;
    /**
     * 租住教师所在部门
     */
    private String rentalteacherdepartment;
    /**
     * 租住教师编号
     */
    private String rentallteachernumber;
    /**
     * 租住教师姓名
     */
    private String rentalteachername;
    /**
     * 备注说明
     */
    private String houseremarks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHousefloornumber() {
        return housefloornumber;
    }

    public void setHousefloornumber(String housefloornumber) {
        this.housefloornumber = housefloornumber;
    }

    public String getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(String housenumber) {
        this.housenumber = housenumber;
    }

    public String getApplycheckdate() {
        return applycheckdate;
    }

    public void setApplycheckdate(String applycheckdate) {
        this.applycheckdate = applycheckdate;
    }

    public Integer getApplytime() {
        return applytime;
    }

    public void setApplytime(Integer applytime) {
        this.applytime = applytime;
    }

    public String getApplyexpiredate() {
        return applyexpiredate;
    }

    public void setApplyexpiredate(String applyexpiredate) {
        this.applyexpiredate = applyexpiredate;
    }

    public String getHouserentaltype() {
        return houserentaltype;
    }

    public void setHouserentaltype(String houserentaltype) {
        this.houserentaltype = houserentaltype;
    }

    public Float getHousearea() {
        return housearea;
    }

    public void setHousearea(Float housearea) {
        this.housearea = housearea;
    }

    public Float getSpecialrentalhouse() {
        return specialrentalhouse;
    }

    public void setSpecialrentalhouse(Float specialrentalhouse) {
        this.specialrentalhouse = specialrentalhouse;
    }

    public String getWhetherdoubleone() {
        return whetherdoubleone;
    }

    public void setWhetherdoubleone(String whetherdoubleone) {
        this.whetherdoubleone = whetherdoubleone;
    }

    public String getWhetherchild() {
        return whetherchild;
    }

    public void setWhetherchild(String whetherchild) {
        this.whetherchild = whetherchild;
    }

    public String getRentalteacherdepartment() {
        return rentalteacherdepartment;
    }

    public void setRentalteacherdepartment(String rentalteacherdepartment) {
        this.rentalteacherdepartment = rentalteacherdepartment;
    }

    public String getRentallteachernumber() {
        return rentallteachernumber;
    }

    public void setRentallteachernumber(String rentallteachernumber) {
        this.rentallteachernumber = rentallteachernumber;
    }

    public String getRentalteachername() {
        return rentalteachername;
    }

    public void setRentalteachername(String rentalteachername) {
        this.rentalteachername = rentalteachername;
    }

    public String getHouseremarks() {
        return houseremarks;
    }

    public void setHouseremarks(String houseremarks) {
        this.houseremarks = houseremarks;
    }

    @Override
    public String toString() {
        return "HouseRentingSituation{" +
        ", id=" + id +
        ", housefloornumber=" + housefloornumber +
        ", housenumber=" + housenumber +
        ", applycheckdate=" + applycheckdate +
        ", applytime=" + applytime +
        ", applyexpiredate=" + applyexpiredate +
        ", houserentaltype=" + houserentaltype +
        ", housearea=" + housearea +
        ", specialrentalhouse=" + specialrentalhouse +
        ", whetherdoubleone=" + whetherdoubleone +
        ", whetherchild=" + whetherchild +
        ", rentalteacherdepartment=" + rentalteacherdepartment +
        ", rentallteachernumber=" + rentallteachernumber +
        ", rentalteachername=" + rentalteachername +
        ", houseremarks=" + houseremarks +
        "}";
    }
}

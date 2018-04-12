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
 * @since 2018-04-12
 */
public class HouseHistory implements Serializable {

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
     * 房间租住类型
     */
    private String houserentaltype;
    /**
     * 房间面积
     */
    private Float housearea;
    /**
     * 申请租住日期
     */
    private String applycheckdate;
    /**
     * 租住到期日期
     */
    private String applyexpiredate;
    /**
     * 申请退租日期
     */
    private String applyretreatdate;
    /**
     * 是否带小孩
     */
    private String whetherchild;
    /**
     * 租住教师姓名
     */
    private String rentalteachername;
    /**
     * 租住教师所在部门
     */
    private String rentalteacherdepartment;


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

    public String getApplycheckdate() {
        return applycheckdate;
    }

    public void setApplycheckdate(String applycheckdate) {
        this.applycheckdate = applycheckdate;
    }

    public String getApplyexpiredate() {
        return applyexpiredate;
    }

    public void setApplyexpiredate(String applyexpiredate) {
        this.applyexpiredate = applyexpiredate;
    }

    public String getApplyretreatdate() {
        return applyretreatdate;
    }

    public void setApplyretreatdate(String applyretreatdate) {
        this.applyretreatdate = applyretreatdate;
    }

    public String getWhetherchild() {
        return whetherchild;
    }

    public void setWhetherchild(String whetherchild) {
        this.whetherchild = whetherchild;
    }

    public String getRentalteachername() {
        return rentalteachername;
    }

    public void setRentalteachername(String rentalteachername) {
        this.rentalteachername = rentalteachername;
    }

    public String getRentalteacherdepartment() {
        return rentalteacherdepartment;
    }

    public void setRentalteacherdepartment(String rentalteacherdepartment) {
        this.rentalteacherdepartment = rentalteacherdepartment;
    }

    @Override
    public String toString() {
        return "HouseHistory{" +
        ", id=" + id +
        ", housefloornumber=" + housefloornumber +
        ", housenumber=" + housenumber +
        ", houserentaltype=" + houserentaltype +
        ", housearea=" + housearea +
        ", applycheckdate=" + applycheckdate +
        ", applyexpiredate=" + applyexpiredate +
        ", applyretreatdate=" + applyretreatdate +
        ", whetherchild=" + whetherchild +
        ", rentalteachername=" + rentalteachername +
        ", rentalteacherdepartment=" + rentalteacherdepartment +
        "}";
    }
}

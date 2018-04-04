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
 * @since 2018-04-03
 */
public class HousePub implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 公用房所在楼号
     */
    private String housefloornumber;
    /**
     * 公用房编号
     */
    private String housenumber;
    /**
     * 公用房面积
     */
    private Float housearea;
    /**
     * 公用房使用状态
     */
    private String housestatus;
    /**
     * 公用房使用类型
     */
    private String housetype;
    /**
     * 房间使用部门
     */
    private String housedepartment;
    /**
     * 公用房备注
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

    public Float getHousearea() {
        return housearea;
    }

    public void setHousearea(Float housearea) {
        this.housearea = housearea;
    }

    public String getHousestatus() {
        return housestatus;
    }

    public void setHousestatus(String housestatus) {
        this.housestatus = housestatus;
    }

    public String getHousetype() {
        return housetype;
    }

    public void setHousetype(String housetype) {
        this.housetype = housetype;
    }

    public String getHousedepartment() {
        return housedepartment;
    }

    public void setHousedepartment(String housedepartment) {
        this.housedepartment = housedepartment;
    }

    public String getHouseremarks() {
        return houseremarks;
    }

    public void setHouseremarks(String houseremarks) {
        this.houseremarks = houseremarks;
    }

    @Override
    public String toString() {
        return "HousePub{" +
        ", id=" + id +
        ", housefloornumber=" + housefloornumber +
        ", housenumber=" + housenumber +
        ", housearea=" + housearea +
        ", housestatus=" + housestatus +
        ", housetype=" + housetype +
        ", housedepartment=" + housedepartment +
        ", houseremarks=" + houseremarks +
        "}";
    }
}

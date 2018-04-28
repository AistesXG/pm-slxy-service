package com.pm.slxy.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-28
 */
public class Zjhsbz implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 保障期单间每平方米价格
     */
    private Float bzqdj;
    /**
     * 保障期单元房每平方米价格
     */
    private Float bzqdyf;
    /**
     * 延长期单间每平方米价格
     */
    private Float ycqdj;
    /**
     * 延长期单元房每平方米价格
     */
    private Float ycqdyf;
    /**
     * 超限期单间每平方米价格
     */
    private Float cxqdj;
    /**
     * 超限期单元房每平方米价格
     */
    private Float cxqdyf;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBzqdj() {
        return bzqdj;
    }

    public void setBzqdj(Float bzqdj) {
        this.bzqdj = bzqdj;
    }

    public Float getBzqdyf() {
        return bzqdyf;
    }

    public void setBzqdyf(Float bzqdyf) {
        this.bzqdyf = bzqdyf;
    }

    public Float getYcqdj() {
        return ycqdj;
    }

    public void setYcqdj(Float ycqdj) {
        this.ycqdj = ycqdj;
    }

    public Float getYcqdyf() {
        return ycqdyf;
    }

    public void setYcqdyf(Float ycqdyf) {
        this.ycqdyf = ycqdyf;
    }

    public Float getCxqdj() {
        return cxqdj;
    }

    public void setCxqdj(Float cxqdj) {
        this.cxqdj = cxqdj;
    }

    public Float getCxqdyf() {
        return cxqdyf;
    }

    public void setCxqdyf(Float cxqdyf) {
        this.cxqdyf = cxqdyf;
    }

    @Override
    public String toString() {
        return "Zjhsbz{" +
                ", id=" + id +
                ", bzqdj=" + bzqdj +
                ", bzqdyf=" + bzqdyf +
                ", ycqdj=" + ycqdj +
                ", ycqdyf=" + ycqdyf +
                ", cxqdj=" + cxqdj +
                ", cxqdyf=" + cxqdyf +
                "}";
    }
}

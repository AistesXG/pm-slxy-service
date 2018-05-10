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
 * @since 2018-04-17
 */
public class House implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 租住者姓名
     */
    private String zzzxm;
    /**
     * 租住者所在部门
     */
    private String zzzszbm;
    /**
     * 房间编号
     */
    private String fjbh;
    /**
     * 房间楼号
     */
    private String fjlh;
    /**
     * 房间面积
     */
    private Float fjmj;
    /**
     * 租住状态
     */
    private String zzzt;
    /**
     * 房间备注
     */
    private String fjbz;
    /**
     * 该房屋是否被申请了
     */
    private String apply;

    public String getApply() {
        return apply;
    }

    public void setApply(String apply) {
        this.apply = apply;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getZzzxm() {
        return zzzxm;
    }

    public void setZzzxm(String zzzxm) {
        this.zzzxm = zzzxm;
    }

    public String getZzzszbm() {
        return zzzszbm;
    }

    public void setZzzszbm(String zzzszbm) {
        this.zzzszbm = zzzszbm;
    }

    public String getFjbh() {
        return fjbh;
    }

    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    public String getFjlh() {
        return fjlh;
    }

    public void setFjlh(String fjlh) {
        this.fjlh = fjlh;
    }

    public Float getFjmj() {
        return fjmj;
    }

    public void setFjmj(Float fjmj) {
        this.fjmj = fjmj;
    }

    public String getZzzt() {
        return zzzt;
    }

    public void setZzzt(String zzzt) {
        this.zzzt = zzzt;
    }

    public String getFjbz() {
        return fjbz;
    }

    public void setFjbz(String fjbz) {
        this.fjbz = fjbz;
    }

    @Override
    public String toString() {
        return "House{" +
                ", id=" + id +
                ", zzzxm=" + zzzxm +
                ", zzzszbm=" + zzzszbm +
                ", fjbh=" + fjbh +
                ", fjlh=" + fjlh +
                ", fjmj=" + fjmj +
                ", zzzt=" + zzzt +
                ", fjbz=" + fjbz +
                ", apply=" + apply +
                "}";
    }
}

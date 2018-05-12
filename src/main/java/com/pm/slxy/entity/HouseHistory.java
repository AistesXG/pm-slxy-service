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
 * @since 2018-05-11
 */
public class HouseHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 房间楼号
     */
    private String fjlh;
    /**
     * 房间编号
     */
    private String fjbh;
    /**
     * 房间租住类型
     */
    private String fjzzlx;
    /**
     * 房间面积
     */
    private Float fjmj;
    /**
     * 申请租住日期
     */
    private String sqzzrq;
    /**
     * 租住到期日期
     */
    private String zzdqrq;
    /**
     * 申请退租日期
     */
    private String sqtzrq;
    /**
     * 是否续租
     */
    private String sfxz;
    /**
     * 是否超限期带小孩
     */
    private String sfcxqdxh;
    /**
     * 租住教师姓名
     */
    private String zzjsxm;
    /**
     * 租住教师编号
     */
    private String zzjsbh;
    /**
     * 租住教师所在部门
     */
    private String zzjsszbm;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFjlh() {
        return fjlh;
    }

    public void setFjlh(String fjlh) {
        this.fjlh = fjlh;
    }

    public String getFjbh() {
        return fjbh;
    }

    public void setFjbh(String fjbh) {
        this.fjbh = fjbh;
    }

    public String getFjzzlx() {
        return fjzzlx;
    }

    public void setFjzzlx(String fjzzlx) {
        this.fjzzlx = fjzzlx;
    }

    public Float getFjmj() {
        return fjmj;
    }

    public void setFjmj(Float fjmj) {
        this.fjmj = fjmj;
    }

    public String getSqzzrq() {
        return sqzzrq;
    }

    public void setSqzzrq(String sqzzrq) {
        this.sqzzrq = sqzzrq;
    }

    public String getZzdqrq() {
        return zzdqrq;
    }

    public void setZzdqrq(String zzdqrq) {
        this.zzdqrq = zzdqrq;
    }

    public String getSqtzrq() {
        return sqtzrq;
    }

    public void setSqtzrq(String sqtzrq) {
        this.sqtzrq = sqtzrq;
    }

    public String getSfxz() {
        return sfxz;
    }

    public void setSfxz(String sfxz) {
        this.sfxz = sfxz;
    }

    public String getSfcxqdxh() {
        return sfcxqdxh;
    }

    public void setSfcxqdxh(String sfcxqdxh) {
        this.sfcxqdxh = sfcxqdxh;
    }

    public String getZzjsxm() {
        return zzjsxm;
    }

    public void setZzjsxm(String zzjsxm) {
        this.zzjsxm = zzjsxm;
    }

    public String getZzjsbh() {
        return zzjsbh;
    }

    public void setZzjsbh(String zzjsbh) {
        this.zzjsbh = zzjsbh;
    }

    public String getZzjsszbm() {
        return zzjsszbm;
    }

    public void setZzjsszbm(String zzjsszbm) {
        this.zzjsszbm = zzjsszbm;
    }

    @Override
    public String toString() {
        return "HouseHistory{" +
                ", id=" + id +
                ", fjlh=" + fjlh +
                ", fjbh=" + fjbh +
                ", fjzzlx=" + fjzzlx +
                ", fjmj=" + fjmj +
                ", sqzzrq=" + sqzzrq +
                ", zzdqrq=" + zzdqrq +
                ", sqtzrq=" + sqtzrq +
                ", sfxz=" + sfxz +
                ", sfcxqdxh=" + sfcxqdxh +
                ", zzjsxm=" + zzjsxm +
                ", zzjsbh=" + zzjsbh +
                ", zzjsszbm=" + zzjsszbm +
                "}";
    }
}

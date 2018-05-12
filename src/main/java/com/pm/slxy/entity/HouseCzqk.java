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
 * @since 2018-05-08
 */
public class HouseCzqk implements Serializable {

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
     * 申请租住日期
     */
    private String sqzzrq;
    /**
     * 租住年限
     */
    private Integer zznx;
    /**
     * 审批状态
     */
    private String spzt;
    /**
     * 租住到期日期
     */
    private String zzdqrq;
    /**
     * 房间租住类型
     */
    private String fjzzlx;
    /**
     * 房间面积
     */
    private Float fjmj;
    /**
     * 特殊租住房间系数
     */
    private Float tszzxs;
    /**
     * 是否属于双职工只租住一个房子
     */
    private String sfszg;
    /**
     * 是否超限期带小孩
     */
    private String sfcxqdxh;
    /**
     * 租住教师所在部门
     */
    private String zzjsszbm;
    /**
     * 租住教师编号
     */
    private String zzjsbh;
    /**
     * 租住教师姓名
     */
    private String zzjsxm;
    /**
     * 备注说明
     */
    private String bzsm;
    /**
     * 教师参加工作日期
     */
    private String jscjgzrq;
    /**
     * 租房退房和续租的状态
     */
    private String zfxztfzt;
    /**
     * 是否续租
     */
    private String sfxz;

    public String getSfxz() {
        return sfxz;
    }

    public void setSfxz(String sfxz) {
        this.sfxz = sfxz;
    }

    public String getZfxztfzt() {
        return zfxztfzt;
    }

    public void setZfxztfzt(String zfxztfzt) {
        this.zfxztfzt = zfxztfzt;
    }

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

    public String getSqzzrq() {
        return sqzzrq;
    }

    public void setSqzzrq(String sqzzrq) {
        this.sqzzrq = sqzzrq;
    }

    public Integer getZznx() {
        return zznx;
    }

    public void setZznx(Integer zznx) {
        this.zznx = zznx;
    }

    public String getSpzt() {
        return spzt;
    }

    public void setSpzt(String spzt) {
        this.spzt = spzt;
    }

    public String getZzdqrq() {
        return zzdqrq;
    }

    public void setZzdqrq(String zzdqrq) {
        this.zzdqrq = zzdqrq;
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

    public Float getTszzxs() {
        return tszzxs;
    }

    public void setTszzxs(Float tszzxs) {
        this.tszzxs = tszzxs;
    }

    public String getSfszg() {
        return sfszg;
    }

    public void setSfszg(String sfszg) {
        this.sfszg = sfszg;
    }

    public String getSfcxqdxh() {
        return sfcxqdxh;
    }

    public void setSfcxqdxh(String sfcxqdxh) {
        this.sfcxqdxh = sfcxqdxh;
    }

    public String getZzjsszbm() {
        return zzjsszbm;
    }

    public void setZzjsszbm(String zzjsszbm) {
        this.zzjsszbm = zzjsszbm;
    }

    public String getZzjsbh() {
        return zzjsbh;
    }

    public void setZzjsbh(String zzjsbh) {
        this.zzjsbh = zzjsbh;
    }

    public String getZzjsxm() {
        return zzjsxm;
    }

    public void setZzjsxm(String zzjsxm) {
        this.zzjsxm = zzjsxm;
    }

    public String getBzsm() {
        return bzsm;
    }

    public void setBzsm(String bzsm) {
        this.bzsm = bzsm;
    }

    public String getJscjgzrq() {
        return jscjgzrq;
    }

    public void setJscjgzrq(String jscjgzrq) {
        this.jscjgzrq = jscjgzrq;
    }

    @Override
    public String toString() {
        return "HouseCzqk{" +
                ", id=" + id +
                ", fjlh=" + fjlh +
                ", fjbh=" + fjbh +
                ", sqzzrq=" + sqzzrq +
                ", zznx=" + zznx +
                ", spzt=" + spzt +
                ", zzdqrq=" + zzdqrq +
                ", fjzzlx=" + fjzzlx +
                ", fjmj=" + fjmj +
                ", tszzxs=" + tszzxs +
                ", sfszg=" + sfszg +
                ", sfcxqdxh=" + sfcxqdxh +
                ", zzjsszbm=" + zzjsszbm +
                ", zzjsbh=" + zzjsbh +
                ", zzjsxm=" + zzjsxm +
                ", bzsm=" + bzsm +
                ", jscjgzrq=" + jscjgzrq +
                ", zfxztfzt=" + zfxztfzt +
                ", sfxz=" + sfxz +
                "}";
    }
}

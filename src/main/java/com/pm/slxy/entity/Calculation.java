package com.pm.slxy.entity;

import java.io.Serializable;

public class Calculation implements Serializable {

    /**
     * 房间楼号
     */
    private String fjlh;
    /**
     * 房间编号
     */
    private String fjbh;
    /**
     * 申请日期
     */
    private String sfqr;
    /**
     * 到期日期
     */
    private String dqrq;
    /**
     * 租住类型
     */
    private String zzlx;
    /**
     * 房间面积
     */
    private Float fjmj;
    /**
     * 原始租金标准
     */
    private Float zjbz;
    /**
     * 是否属于双职工只租住一个房子
     */
    private String sfszg;
    /**
     * 是否超限期带小孩
     */
    private String sfcxqdxh;
    /**
     * 计算系数
     */
    private Float jsxs;
    /**
     * 所在部门
     */
    private String szbm;
    /**
     * 教师姓名
     */
    private String jsxm;
    /**
     * 月租费
     */
    private Float yzf;
    /**
     * 月数
     */
    private Integer month;
    /**
     * 季度租金
     */
    private Float jdzj;
    /**
     * 工作日期
     */
    private String gzrq;
    /**
     * 特殊系数
     */
    private Float tszs;
    /**
     * 总和
     */
    private Float sum;

    public Float getSum() {
        return sum;
    }

    public void setSum(Float sum) {
        this.sum = sum;
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

    public String getSfqr() {
        return sfqr;
    }

    public void setSfqr(String sfqr) {
        this.sfqr = sfqr;
    }

    public String getDqrq() {
        return dqrq;
    }

    public void setDqrq(String dqrq) {
        this.dqrq = dqrq;
    }

    public String getZzlx() {
        return zzlx;
    }

    public void setZzlx(String zzlx) {
        this.zzlx = zzlx;
    }

    public Float getFjmj() {
        return fjmj;
    }

    public void setFjmj(Float fjmj) {
        this.fjmj = fjmj;
    }

    public Float getZjbz() {
        return zjbz;
    }

    public void setZjbz(Float zjbz) {
        this.zjbz = zjbz;
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

    public Float getJsxs() {
        return jsxs;
    }

    public void setJsxs(Float jsxs) {
        this.jsxs = jsxs;
    }

    public String getSzbm() {
        return szbm;
    }

    public void setSzbm(String szbm) {
        this.szbm = szbm;
    }

    public String getJsxm() {
        return jsxm;
    }

    public void setJsxm(String jsxm) {
        this.jsxm = jsxm;
    }

    public Float getYzf() {
        return yzf;
    }

    public void setYzf(Float yzf) {
        this.yzf = yzf;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Float getJdzj() {
        return jdzj;
    }

    public void setJdzj(Float jdzj) {
        this.jdzj = jdzj;
    }

    public String getGzrq() {
        return gzrq;
    }

    public void setGzrq(String gzrq) {
        this.gzrq = gzrq;
    }

    public Float getTszs() {
        return tszs;
    }

    public void setTszs(Float tszs) {
        this.tszs = tszs;
    }

    @Override
    public String toString() {
        return "Calculation{" +
                "fjlh='" + fjlh + '\'' +
                ", fjbh='" + fjbh + '\'' +
                ", sfqr='" + sfqr + '\'' +
                ", dqrq='" + dqrq + '\'' +
                ", zzlx='" + zzlx + '\'' +
                ", fjmj=" + fjmj +
                ", zjbz=" + zjbz +
                ", sfszg='" + sfszg + '\'' +
                ", sfcxqdxh='" + sfcxqdxh + '\'' +
                ", jsxs=" + jsxs +
                ", szbm='" + szbm + '\'' +
                ", jsxm='" + jsxm + '\'' +
                ", yzf=" + yzf +
                ", month=" + month +
                ", jdzj=" + jdzj +
                ", gzrq='" + gzrq + '\'' +
                ", tszs=" + tszs +
                ", sum=" + sum +
                '}';
    }
}

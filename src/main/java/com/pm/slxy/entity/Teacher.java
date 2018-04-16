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
 * @since 2018-04-16
 */
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 教师姓名
     */
    private String xm;
    /**
     * 教工编号
     */
    private String jggh;
    /**
     * 性别
     */
    private String xb;
    /**
     * 身份证号码
     */
    private String sfzh;
    /**
     * 出生年月
     */
    private String csrq;
    /**
     * 学历
     */
    private String xl;
    /**
     * 参加工作时间
     */
    private String cjgzrq;
    /**
     * 申请住房日期
     */
    private String sqzfrq;
    /**
     * 所在部门
     */
    private String szbm;
    /**
     * 籍贯
     */
    private String jg;
    /**
     * 租房状态
     */
    private String zfzt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getJggh() {
        return jggh;
    }

    public void setJggh(String jggh) {
        this.jggh = jggh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getCsrq() {
        return csrq;
    }

    public void setCsrq(String csrq) {
        this.csrq = csrq;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getCjgzrq() {
        return cjgzrq;
    }

    public void setCjgzrq(String cjgzrq) {
        this.cjgzrq = cjgzrq;
    }

    public String getSqzfrq() {
        return sqzfrq;
    }

    public void setSqzfrq(String sqzfrq) {
        this.sqzfrq = sqzfrq;
    }

    public String getSzbm() {
        return szbm;
    }

    public void setSzbm(String szbm) {
        this.szbm = szbm;
    }

    public String getJg() {
        return jg;
    }

    public void setJg(String jg) {
        this.jg = jg;
    }

    public String getZfzt() {
        return zfzt;
    }

    public void setZfzt(String zfzt) {
        this.zfzt = zfzt;
    }

    @Override
    public String toString() {
        return "Teacher{" +
        ", id=" + id +
        ", xm=" + xm +
        ", jggh=" + jggh +
        ", xb=" + xb +
        ", sfzh=" + sfzh +
        ", csrq=" + csrq +
        ", xl=" + xl +
        ", cjgzrq=" + cjgzrq +
        ", sqzfrq=" + sqzfrq +
        ", szbm=" + szbm +
        ", jg=" + jg +
        ", zfzt=" + zfzt +
        "}";
    }
}

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
 * @since 2018-04-16
 */
public class HousePub implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 公用房所在楼号
     */
    private String fjlh;
    /**
     * 公用房编号
     */
    private String fjbh;
    /**
     * 公用房面积
     */
    private Float fjmj;
    /**
     * 公用房使用状态
     */
    private String fjsyzt;
    /**
     * 公用房使用类型
     */
    private String fjsylx;
    /**
     * 房间使用部门
     */
    private String fjsybm;
    /**
     * 公用房备注
     */
    private String fjbz;


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

    public Float getFjmj() {
        return fjmj;
    }

    public void setFjmj(Float fjmj) {
        this.fjmj = fjmj;
    }

    public String getFjsyzt() {
        return fjsyzt;
    }

    public void setFjsyzt(String fjsyzt) {
        this.fjsyzt = fjsyzt;
    }

    public String getFjsylx() {
        return fjsylx;
    }

    public void setFjsylx(String fjsylx) {
        this.fjsylx = fjsylx;
    }

    public String getFjsybm() {
        return fjsybm;
    }

    public void setFjsybm(String fjsybm) {
        this.fjsybm = fjsybm;
    }

    public String getFjbz() {
        return fjbz;
    }

    public void setFjbz(String fjbz) {
        this.fjbz = fjbz;
    }

    @Override
    public String toString() {
        return "HousePub{" +
                ", id=" + id +
                ", fjlh=" + fjlh +
                ", fjbh=" + fjbh +
                ", fjmj=" + fjmj +
                ", fjsyzt=" + fjsyzt +
                ", fjsylx=" + fjsylx +
                ", fjsybm=" + fjsybm +
                ", fjbz=" + fjbz +
                "}";
    }
}

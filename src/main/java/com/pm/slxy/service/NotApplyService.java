package com.pm.slxy.service;

import com.pm.slxy.entity.NotApply;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-12
 */
public interface NotApplyService extends IService<NotApply> {

    /**
     * 根据房屋租住情况的id来查找status
     *
     * @param id
     * @return
     */
    String selectStatusById(int id);

    /**
     * 根据status去查找houseCzqk表中的数据，更改其他的字段
     *
     * @param notApply
     * @return
     */
    String addNotApply(NotApply notApply,int id);
}

package com.pm.slxy.service;

import com.pm.slxy.entity.HousePub;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 房产信息服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-03
 */
public interface HousePubService extends IService<HousePub> {

    /**
     * 查找房产信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHouses(ModelAndView modelAndView);

}

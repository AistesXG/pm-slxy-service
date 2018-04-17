package com.pm.slxy.service;

import com.pm.slxy.entity.House;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-17
 */
public interface HouseService extends IService<House> {
    /**
     * 查找教师用房房产信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHouses(ModelAndView modelAndView);
}

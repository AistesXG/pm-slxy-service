package com.pm.slxy.service;

import com.pm.slxy.entity.HouseRentingSituation;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-11
 */
public interface HouseRentingSituationService extends IService<HouseRentingSituation> {

    /**
     * 添加租房的信息
     *
     * @param houseRentingSituation
     * @return
     */
    String rentalHouse(HouseRentingSituation houseRentingSituation);

    /**
     * 查找租房的信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHouseRentingHouse(ModelAndView modelAndView);


    /**
     * 退房
     *
     * @param id
     * @return
     */
    String retreatHouse(int id);
}

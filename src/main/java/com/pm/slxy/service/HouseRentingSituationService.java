package com.pm.slxy.service;

import com.pm.slxy.entity.HouseRentingSituation;
import com.baomidou.mybatisplus.service.IService;

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
}

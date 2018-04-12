package com.pm.slxy.controller;


import com.pm.slxy.entity.HouseRentingSituation;
import com.pm.slxy.service.HouseRentingSituationService;
import com.pm.slxy.utils.SysControllerFilter;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-11
 */
@Controller
@RequestMapping("/houseRentingSituation")
public class HouseRentingSituationController {

    @Autowired
    private HouseRentingSituationService houseRentingSituationService;

    @RequestMapping(value = "/rentalHouse")
    @SysControllerFilter(name = "rentalHouse")
    @ResponseBody
    public String rentalHouse(HouseRentingSituation houseRentingSituation) throws Exception {
        return houseRentingSituationService.rentalHouse(houseRentingSituation);
    }

    @RequestMapping(value = "/houseRentingHouseList")
    @SysControllerFilter(name = "houseRentingHouseList")
    public ModelAndView selectHouseRentingHouse(ModelAndView modelAndView) throws Exception {
        return houseRentingSituationService.selectHouseRentingHouse(modelAndView);
    }

    @RequestMapping(value = "/retreatHouse")
    @SysControllerFilter(name = "retreatHouse")
    @ResponseBody
    public String retreatHouse(@Param("id") String id) throws Exception {
        return houseRentingSituationService.retreatHouse(Integer.parseInt(id));
    }
}


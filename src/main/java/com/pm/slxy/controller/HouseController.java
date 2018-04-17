package com.pm.slxy.controller;


import com.pm.slxy.service.HouseService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-17
 */
@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @RequestMapping(value = "/houseList")
    @SysControllerFilter(name = "houseList")
    public ModelAndView selectHouses(ModelAndView modelAndView) throws Exception {
        return houseService.selectHouses(modelAndView);
    }
}


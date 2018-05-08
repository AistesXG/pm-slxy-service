package com.pm.slxy.controller;


import com.pm.slxy.entity.HouseCzqk;
import com.pm.slxy.service.HouseCzqkService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-06
 */
@Controller
@RequestMapping("/houseCzqk")
public class HouseCzqkController {

    @Autowired
    private HouseCzqkService houseCzqkService;

    @RequestMapping(value = "/HouseCzqkList")
    @SysControllerFilter(name = "HouseCzqkList")
    public ModelAndView selectHouseCzqks(ModelAndView modelAndView) throws Exception {
        return houseCzqkService.selectHouseCzqks(modelAndView);
    }

    @RequestMapping(value = "/selectHouseToCzqkById")
    @SysControllerFilter(name = "selectHouseToCzqkById")
    public ModelAndView selectHouseToCzqkById(ModelAndView modelAndView, String id) {
        return houseCzqkService.selectHouseToCzqkById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/addHouseCzqk")
    @SysControllerFilter(name = "addHouseCzqk")
    @ResponseBody
    public String addHouseCzqk(HouseCzqk houseCzqk) throws Exception {
        return houseCzqkService.addHouseCzqk(houseCzqk);
    }

    @RequestMapping(value = "/selectHouseCzqkById")
    @SysControllerFilter(name = "selectHouseCzqkById")
    public ModelAndView selectHouseCzqkById(ModelAndView modelAndView, String id) throws Exception{
        return houseCzqkService.selectHouseCzqkById(modelAndView,Integer.parseInt(id));
    }
}


package com.pm.slxy.controller;


import com.pm.slxy.entity.Zjhsbz;
import com.pm.slxy.service.ZjhsbzService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-28
 */
@Controller
@RequestMapping("/zjhsbz")
public class ZjhsbzController {

    @Autowired
    private ZjhsbzService zjhsbzService;

    @RequestMapping(value = "/housePriceList")
    @SysControllerFilter(name = "housePriceList")
    public ModelAndView selectPrice(ModelAndView modelAndView) throws Exception {
        return zjhsbzService.selectPrice(modelAndView);
    }

    @RequestMapping(value = "/selectPriceById")
    @SysControllerFilter(name = "selectPriceById")
    public ModelAndView selectPriceById(ModelAndView modelAndView, String id) throws Exception {
        return zjhsbzService.selectPriceById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/updatePrice")
    @SysControllerFilter(name = "updatePrice")
    @ResponseBody
    public String updatePrice(Zjhsbz zjhsbz) throws Exception {
        return zjhsbzService.updatePrice(zjhsbz);
    }
}


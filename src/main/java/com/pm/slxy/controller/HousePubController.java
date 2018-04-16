package com.pm.slxy.controller;


import com.pm.slxy.entity.HousePub;
import com.pm.slxy.service.HousePubService;
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
 * @since 2018-04-03
 */
@Controller
@RequestMapping("/housePub")
public class HousePubController {

    @Autowired
    private HousePubService housePubService;

    @RequestMapping(value = "/housePubList")
    @SysControllerFilter(name = "housePubList")
    public ModelAndView selectHousePubs(ModelAndView modelAndView) throws Exception {
        return housePubService.selectHousePubs(modelAndView);
    }

    @RequestMapping(value = "/addHousePub")
    @SysControllerFilter(name = "addHousePub")
    @ResponseBody
    public String addHousePub(HousePub housePub) throws Exception {
        return housePubService.addHousePub(housePub);
    }

    @RequestMapping(value = "/deleteHousePub")
    @SysControllerFilter(name = "deleteHousePub")
    @ResponseBody
    public String deleteHousePubByIds(String ids) throws Exception {
        return housePubService.deleteHousePubByIds(ids);
    }

    @RequestMapping(value = "/selectHousePubById")
    @SysControllerFilter(name = "selectHousePubById")
    public ModelAndView selectHousePubById(ModelAndView modelAndView, String id) throws Exception {
        return housePubService.selectHousePubById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/updateHousePub")
    @SysControllerFilter(name = "updateHousePub")
    @ResponseBody
    public String updateHousePub(HousePub housePub) throws Exception {
        return housePubService.updateHousePub(housePub);
    }


}


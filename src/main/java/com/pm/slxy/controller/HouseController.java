package com.pm.slxy.controller;


import com.pm.slxy.entity.House;
import com.pm.slxy.service.HouseService;
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

    @RequestMapping(value = "/addHouse")
    @SysControllerFilter(name = "addHouse")
    @ResponseBody
    public String addHouse(House house) throws Exception {
        return houseService.addHouse(house);
    }

    @RequestMapping(value = "/updateHouse")
    @SysControllerFilter(name = "updateHouse")
    @ResponseBody
    public String updateHouse(House house) throws Exception {
        return houseService.updateHouse(house);
    }

    @RequestMapping(value = "/selectHouseById")
    @SysControllerFilter(name = "selectHouseById")
    public ModelAndView selectHouseById(ModelAndView modelAndView, String id) throws Exception {
        return houseService.selectHouseById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/deleteHouse")
    @SysControllerFilter(name = "deleteHouse")
    @ResponseBody
    public String deleteHouseByIds(String ids) throws Exception {
        return houseService.deleteHouseByIds(ids);
    }

    @RequestMapping(value = "/selectHouseDetailById")
    @SysControllerFilter(name = "selectHouseDetailById")
    @ResponseBody
    public String selectHouseDetailById(String id) throws Exception {
        return houseService.selectHouseDetailById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectHouseByStatus")
    @SysControllerFilter(name = "selectHouseByStatus")
    public ModelAndView selectHouseByStatus(ModelAndView modelAndView, String zzzt) throws Exception {
        return houseService.selectHouseByStatus(modelAndView, zzzt);
    }

    @RequestMapping(value = "/checkOutHouse")
    @SysControllerFilter(name = "checkOutHouse")
    @ResponseBody
    public String checkOutHouse(String id) throws Exception {
        return houseService.checkOutHouse(Integer.parseInt(id));
    }
}


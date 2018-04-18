package com.pm.slxy.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.House;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.service.HousePubService;
import com.pm.slxy.service.HouseService;
import com.pm.slxy.service.TeacherService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author furg@senthink.com
 * @date 2018/3/23
 */
@Controller
@RequestMapping(value = "/jump")
public class ViewJumpController {


    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HousePubService housePubService;
    @Autowired
    private HouseService houseService;

    /**
     * 跳转到登录页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpLogin")
    public ModelAndView jumpLogin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("../../login");
        return modelAndView;
    }

    /**
     * 跳转到添加管理员页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddAdmin")
    @SysControllerFilter(name = "jumpAddAdmin")
    public ModelAndView jumpAddAdmin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("admin/addAdmin");
        return modelAndView;
    }

    /**
     * 跳转到首页
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpHome")
    @SysControllerFilter(name = "jumpHome")
    public ModelAndView jumpHome(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 跳转到教师添加页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddTeacher")
    @SysControllerFilter(name = "jumpAddTeacher")
    public ModelAndView jumpAddTeacher(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("teacher/addTeacher");
        return modelAndView;
    }

    /**
     * 跳转到404页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping("/jump404")
    @SysControllerFilter(name = "jump404")
    public ModelAndView jump404(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("404");
        return modelAndView;
    }

    /**
     * 跳转到添加公用房屋页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddHousePub")
    @SysControllerFilter(name = "jumpAddHousePub")
    public ModelAndView jumpAddHousePub(ModelAndView modelAndView) throws Exception {
        List<String> departments = teacherService.selectDepartment();
        modelAndView.addObject("departments", departments);
        modelAndView.setViewName("housePub/addHousePub");
        return modelAndView;
    }

    /**
     * 跳转到添加教师用房页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddHouse")
    @SysControllerFilter(name = "jumpAddHouse")
    public ModelAndView jumpAddHouse(ModelAndView modelAndView) throws Exception {
        List<String> departments = teacherService.selectDepartment();
        modelAndView.addObject("departments", departments);
        modelAndView.setViewName("house/addHouse");
        return modelAndView;
    }

    /**
     * 跳转到房屋的操作页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpHousePubDetailOperate")
    @SysControllerFilter(name = "jumpHousePubDetailOperate")
    public ModelAndView jumpHousePubDetailOperate(ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("housePubList", housePubService.selectList(new EntityWrapper<HousePub>()));
        modelAndView.setViewName("housePub/housePubDetailOperate");
        return modelAndView;
    }

    /**
     * 跳转到房屋的操作页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpHouseDetailOperate")
    @SysControllerFilter(name = "jumpHouseDetailOperate")
    public ModelAndView jumpHouseDetailOperate(ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("houseList", houseService.selectList(new EntityWrapper<House>()));
        modelAndView.setViewName("house/houseDetailOperate");
        return modelAndView;
    }

}

package com.pm.slxy.controller;

import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author furg@senthink.com
 * @date 2018/3/23
 */
@Controller
@RequestMapping(value = "/jump")
public class ViewJumpController {

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
     * 跳转到修改管理员页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpUpdateAdmin")
    @SysControllerFilter(name = "jumpUpdateAdmin")
    public ModelAndView jumpUpdateAdmin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("admin/updateAdmin");
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
     * 跳转到修改教师页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpUpdateTeacher")
    @SysControllerFilter(name = "jumpUpdateTeacher")
    public ModelAndView jumpUpdateTeacher(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("teacher/updateTeacher");
        return modelAndView;
    }

    /**
     * 跳转到添加房屋页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddHousePub")
    @SysControllerFilter(name = "jumpAddHousePub")
    public ModelAndView jumpAddHouse(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("housePub/addHousePub");
        return modelAndView;
    }
}

package com.pm.slxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author furg@senthink.com
 * @date 2018/3/23
 */
@Controller
@RequestMapping(value = "/jump")
public class ViewJump {

    /**
     * 跳转到添加页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddAdmin")
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
    public ModelAndView jumpHome(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 跳转到修改页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpUpdateAdmin")
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
    public ModelAndView jump404(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("404");
        return modelAndView;
    }
}

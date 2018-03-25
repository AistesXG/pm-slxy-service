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
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddAdmin")
    public ModelAndView jumpAddAdmin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("addAdmin");
        return modelAndView;
    }

    /**
     * 跳转到首页
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
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpUpdateAdmin")
    public ModelAndView jumpUpdateAdmin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("updateAdmin");
        return modelAndView;
    }
}

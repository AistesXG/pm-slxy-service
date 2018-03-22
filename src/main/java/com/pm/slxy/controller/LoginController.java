package com.pm.slxy.controller;

import com.pm.slxy.entity.Admin;
import com.pm.slxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author furg@senthink.com
 * @date 2018/3/22
 */
@Controller
public class LoginController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     *
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/login")
    public ModelAndView login(ModelAndView modelAndView, Admin admin) throws Exception {
        if (admin != null) {
            List<Admin> admins = adminService.login(admin.getUser(), admin.getPass());
            modelAndView.addObject("admins", admins);
            if (admins.get(0).getType().equals("系统管理员")) {
                modelAndView.setViewName("index");
            } else if (admins.get(0).getType().equals("普通管理员")) {
                modelAndView.setViewName("orarginPage");
            } else {
                modelAndView.setViewName("404");
            }
        }
        return modelAndView;
    }
}

package com.pm.slxy.controller;


import com.pm.slxy.entity.User;
import com.pm.slxy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-01
 */
@Controller
@RequestMapping("/User")
@SessionAttributes(value = {"users"})
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param modelAndView
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public ModelAndView Login(ModelAndView modelAndView, User user) {
        if (user != null) {
            List<User> users = userService.Login(user.getUserName(), user.getUserPassword());
            if (users != null) {
                modelAndView.setViewName("index");
                modelAndView.addObject("users", users);
            } else {
                modelAndView.setViewName("../login");
            }
        }
        return modelAndView;
    }

}



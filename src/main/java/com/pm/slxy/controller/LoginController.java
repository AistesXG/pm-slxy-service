package com.pm.slxy.controller;

import com.pm.slxy.Enum.AdminEnum;
import com.pm.slxy.entity.Admin;
import com.pm.slxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author furg@senthink.com
 * @date 2018/3/22
 */
@SessionAttributes(value = {"admins"})
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
    public ModelAndView login(ModelAndView modelAndView, Admin admin, HttpSession session) throws Exception {
        if (admin != null) {
            List<Admin> admins = adminService.login(admin.getUser(), admin.getPass());
            if (CollectionUtils.isEmpty(admins)) {
                modelAndView.setViewName("redirect:/jump/jumpLogin");
            } else {
                modelAndView.addObject("admins", admins.get(0));
                session.setAttribute("admins", admins.get(0));
                if (admins.get(0).getType().equals(AdminEnum.SYSTEM_ADMIN.getRole())) {
                    modelAndView.setViewName("index");
                } else if (admins.get(0).getType().equals(AdminEnum.ORDINARY_ADMIN.getRole())) {
                    modelAndView.setViewName("orarginPage");
                }
            }
        }
        return modelAndView;
    }
}

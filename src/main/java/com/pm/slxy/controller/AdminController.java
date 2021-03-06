package com.pm.slxy.controller;


import com.pm.slxy.entity.Admin;
import com.pm.slxy.service.AdminService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚
 * @since 2018-03-20
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/adminList")
    @SysControllerFilter(name = "adminList")
    public ModelAndView selectAdmins(ModelAndView modelAndView) throws Exception {
        return adminService.selectAdmins(modelAndView);
    }

    @RequestMapping(value = "/deleteAdminByIds")
    @SysControllerFilter(name = "deleteAdminByIds")
    @ResponseBody
    public String deleteAdminByIds(String ids) throws Exception {
        return adminService.deleteAdminByIds(ids);
    }

    @RequestMapping(value = "/addAdmin")
    @SysControllerFilter(name = "/addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin) throws Exception {
        return adminService.addAdmin(admin);
    }

    @RequestMapping(value = "/updateAdmin")
    @SysControllerFilter(name = "/updateAdmin")
    @ResponseBody
    public String updateAdmin(Admin admin) throws Exception {
        return adminService.updateAdmin(admin);
    }

    @RequestMapping(value = "/selectAdmin")
    @SysControllerFilter(name = "selectAdmin")
    public ModelAndView selectAdmin(ModelAndView modelAndView, String id) throws Exception {
        return adminService.selectAdmin(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/updatePass")
    @ResponseBody
    public String updatePass(String user, String pass, HttpServletResponse response) throws Exception {
        response.reset();
        return adminService.updatePass(user, pass);
    }
}


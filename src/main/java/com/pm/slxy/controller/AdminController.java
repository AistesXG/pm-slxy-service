package com.pm.slxy.controller;


import com.pm.slxy.entity.Admin;
import com.pm.slxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

    /**
     * 查询用户列表
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminList")
    public ModelAndView selectUsers(ModelAndView modelAndView) throws Exception {
        List<Admin> adminList = adminService.selectAdmins();
        if (!CollectionUtils.isEmpty(adminList)) {
            modelAndView.addObject("adminList", adminList);
            modelAndView.setViewName("AdminDetails");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }


    /**
     * 批量删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteAdminByIds")
    @ResponseBody
    public String deleteAdminByIds(String ids) throws Exception {
        int delete = adminService.deleteAdminByIds(ids);
        if (delete != 0) {
            return "ok";
        } else {
            return "error";
        }
    }
}


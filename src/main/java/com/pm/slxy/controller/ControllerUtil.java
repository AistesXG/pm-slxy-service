package com.pm.slxy.controller;

import com.pm.slxy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * @author furg@senthink.com
 * @date 2018/3/22
 */
@Controller
public class ControllerUtil {
    @Autowired
    private AdminService adminService;

    /**
     * 检测用户名是否存在
     *
     * @param user
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkUser")
    @ResponseBody
    public String checkUser(String user) throws Exception {
        return adminService.checkUser(user);
    }
}

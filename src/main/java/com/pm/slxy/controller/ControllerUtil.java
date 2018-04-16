package com.pm.slxy.controller;

import com.pm.slxy.service.AdminService;
import com.pm.slxy.service.HousePubService;
import com.pm.slxy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author furg@senthink.com
 * @date 2018/3/22
 */
@Controller
public class ControllerUtil {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HousePubService housePubService;


    @RequestMapping(value = "/checkUser")
    @ResponseBody
    public Map<String, Boolean> checkUser(String user) throws Exception {
        return adminService.checkUser(user);
    }


    @RequestMapping(value = "/checkTeacherNum")
    @ResponseBody
    public Map<String, Boolean> checkTeacherNum(String jggh) throws Exception {
        return teacherService.checkTeacherNum(jggh);
    }


    @RequestMapping(value = "/checkTeacherIdCard")
    @ResponseBody
    public Map<String, Boolean> checkTeacherIdCard(String sfzh) throws Exception {
        return teacherService.checkTeacherIdCard(sfzh);
    }
}

package com.pm.slxy.controller;

import com.pm.slxy.service.AdminService;
import com.pm.slxy.service.HousePubService;
import com.pm.slxy.service.TeacherService;
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
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private HousePubService housePubService;
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

    /**
     * 检测更新或者添加的时候数据库中是否已经存在了教师的编号和身份证号
     *
     * @param teachernumber
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkTeacherNum")
    @ResponseBody
    public String checkTeacherNum(String teachernumber) throws Exception {
        return teacherService.checkTeacherNum(teachernumber);
    }

    /**
     * 检测更新或者添加的时候数据库中是否已经存在了教师的编号和身份证号
     *
     * @param teacheridcard
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/checkTeacherIdCard")
    @ResponseBody
    public String checkTeacherIdCard(String teacheridcard) throws Exception {
        return teacherService.checkTeacheridCard(teacheridcard);
    }
}

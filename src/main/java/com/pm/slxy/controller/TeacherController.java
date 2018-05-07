package com.pm.slxy.controller;


import com.pm.slxy.entity.Teacher;
import com.pm.slxy.service.TeacherService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-26
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/teacherList")
    @SysControllerFilter(name = "teacherList")
    public ModelAndView selectTeacher(ModelAndView modelAndView) throws Exception {
        return teacherService.selectTeachers(modelAndView);
    }

    @RequestMapping(value = "/deleteTeacherByIds")
    @SysControllerFilter(name = "deleteTeacherByIds")
    @ResponseBody
    public String deleteTeacherByIds(String ids) throws Exception {
        return teacherService.deleteTeacherByIds(ids);
    }

    @RequestMapping(value = "/addTeacher")
    @SysControllerFilter(name = "addTeacher")
    @ResponseBody
    public String addTeacher(Teacher teacher) throws Exception {
        return teacherService.addTeacher(teacher);
    }

    @RequestMapping(value = "/updateTeacher")
    @SysControllerFilter(name = "updateTeacher")
    @ResponseBody
    public String updateTeacher(Teacher teacher) throws Exception {
        return teacherService.updateTeacher(teacher);
    }

    @RequestMapping(value = "/selectTeacher")
    @SysControllerFilter(name = "selectTeacher")
    public ModelAndView selectTeacher(ModelAndView modelAndView, String id) throws Exception {
        return teacherService.selectTeacher(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectTeacherById")
    @SysControllerFilter(name = "selectTeacherById")
    public ModelAndView selectTeacherById(ModelAndView modelAndView, String id) throws Exception {
        return teacherService.selectTeacherById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectTeacherByDept")
    @SysControllerFilter(name = "selectTeacherDept")
    public ModelAndView selectTeacherByDept(ModelAndView modelAndView, String szbm) throws Exception {
        return teacherService.selectTeacherByDept(modelAndView, szbm);
    }

    @RequestMapping(value = "/selectTeacherByStatus")
    @SysControllerFilter(name = "selectTeacherByStatus")
    public ModelAndView selectTeacherByStatus(ModelAndView modelAndView, String zfzt) throws Exception {
        return teacherService.selectTeacherByStatus(modelAndView, zfzt);
    }

    @RequestMapping(value = "/selectTeacherXmByDept",produces = "application/json;charset=utf-8")
    @SysControllerFilter(name = "selectTeacherXmByDept")
    @ResponseBody
    public String selectTeacherXmByDept(String szbm) throws Exception {
        return teacherService.selectTeacherXmByDept(szbm);
    }
}


package com.pm.slxy.controller;


import com.pm.slxy.entity.Teacher;
import com.pm.slxy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 查找所有教师信息
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/teacherList")
    public ModelAndView selectTeacher(ModelAndView modelAndView) throws Exception {
        return teacherService.selectTeachers(modelAndView);
    }

    /**
     * 批量删除+单个删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteTeacherByIds")
    @ResponseBody
    public String deleteTeacherByIds(String ids) throws Exception {
        return teacherService.deleteTeacherByIds(ids);
    }

    /**
     * 添加教师信息
     *
     * @param teacher
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addTeacher")
    @ResponseBody
    public String addTeacher(Teacher teacher) throws Exception {
        return teacherService.addTeacher(teacher);
    }

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateTeacher")
    @ResponseBody
    public String updateTeacher(Teacher teacher) throws Exception {
        return teacherService.updateTeacher(teacher);
    }

    /**
     * 根据id查找一个教师信息
     *
     * @param modelAndView
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectTeacher")
    public ModelAndView selectTeacher(ModelAndView modelAndView, String id) throws Exception {
        return teacherService.selectTeacher(modelAndView, Integer.parseInt(id));
    }
}


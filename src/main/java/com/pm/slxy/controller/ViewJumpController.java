package com.pm.slxy.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.Department;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.service.DepartmentService;
import com.pm.slxy.service.HousePubService;
import com.pm.slxy.service.TeacherService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * @author furg@senthink.com
 * @date 2018/3/23
 */
@Controller
@RequestMapping(value = "/jump")
public class ViewJumpController {

    @Autowired
    private HousePubService housePubService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private TeacherService teacherService;

    /**
     * 跳转到登录页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpLogin")
    public ModelAndView jumpLogin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("../../login");
        return modelAndView;
    }

    /**
     * 跳转到添加管理员页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddAdmin")
    @SysControllerFilter(name = "jumpAddAdmin")
    public ModelAndView jumpAddAdmin(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("admin/addAdmin");
        return modelAndView;
    }

    /**
     * 跳转到首页
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpHome")
    @SysControllerFilter(name = "jumpHome")
    public ModelAndView jumpHome(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    /**
     * 跳转到教师添加页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddTeacher")
    @SysControllerFilter(name = "jumpAddTeacher")
    public ModelAndView jumpAddTeacher(ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("depList", departmentService.selectList(new EntityWrapper<Department>()));
        modelAndView.setViewName("teacher/addTeacher");
        return modelAndView;
    }

    /**
     * 跳转到404页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping("/jump404")
    @SysControllerFilter(name = "jump404")
    public ModelAndView jump404(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("404");
        return modelAndView;
    }

    /**
     * 跳转到添加房屋页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpAddHousePub")
    @SysControllerFilter(name = "jumpAddHousePub")
    public ModelAndView jumpAddHouse(ModelAndView modelAndView) throws Exception {
        modelAndView.setViewName("housePub/addHousePub");
        return modelAndView;
    }

    /**
     * 跳转到租房页面
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpRentalHouse")
    @SysControllerFilter(name = "jumpRentalHouse")
    public ModelAndView jumpRentalHouse(ModelAndView modelAndView, String id) throws Exception {
        HousePub housePub = housePubService.selectById(id);
        modelAndView.addObject("housePub", housePub);
        modelAndView.setViewName("house/rentalHouse");
        return modelAndView;
    }

    /**
     * 跳转到教师的详情页
     *
     * @param modelAndView
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/jumpOneTeacher")
    @SysControllerFilter(name = "jumpOneTeacher")
    public ModelAndView jumpOneTeacher(ModelAndView modelAndView, String id) throws Exception {
        Teacher teacher = teacherService.selectById(id);
        modelAndView.addObject("teacher", teacher);
        modelAndView.setViewName("teacher/oneTeacher");
        return modelAndView;
    }

}

package com.pm.slxy.controller;


import com.alibaba.fastjson.JSON;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.HouseCzqk;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseCzqkService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-06
 */
@Controller
@RequestMapping("/houseCzqk")
public class HouseCzqkController {

    @Autowired
    private HouseCzqkService houseCzqkService;
    @Autowired
    private TeacherMapper teacherMapper;

    @RequestMapping(value = "/houseCzqkList")
    @SysControllerFilter(name = "houseCzqkList")
    public ModelAndView selectHouseCzqks(ModelAndView modelAndView) throws Exception {
        return houseCzqkService.selectHouseCzqks(modelAndView);
    }

    @RequestMapping(value = "/selectHouseToCzqkById")
    @SysControllerFilter(name = "selectHouseToCzqkById")
    public ModelAndView selectHouseToCzqkById(ModelAndView modelAndView, String id) {
        return houseCzqkService.selectHouseToCzqkById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/addHouseCzqk")
    @SysControllerFilter(name = "addHouseCzqk")
    @ResponseBody
    public String addHouseCzqk(HouseCzqk houseCzqk) throws Exception {
        return houseCzqkService.addHouseCzqk(houseCzqk);
    }

    @RequestMapping(value = "/selectHouseCzqkById")
    @SysControllerFilter(name = "selectHouseCzqkById")
    public ModelAndView selectHouseCzqkById(ModelAndView modelAndView, String id) throws Exception {
        return houseCzqkService.selectHouseCzqkById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/applyThrough")
    @SysControllerFilter(name = "applyThrough")
    @ResponseBody
    public String applyThrough(String id) throws Exception {
        return houseCzqkService.applyThrough(Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectHouseCzqkReletById")
    @SysControllerFilter(name = "selectHouseCzqkReletById")
    public ModelAndView selectHouseCzqkReletById(ModelAndView modelAndView, String id) throws Exception {
        return houseCzqkService.selectHouseCzqkReletById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/reletHouse")
    @SysControllerFilter(name = "reletHouse")
    @ResponseBody
    public String reletHouse(HouseCzqk houseCzqk) throws Exception {
        return houseCzqkService.reletHouse(houseCzqk);
    }

    @RequestMapping(value = "/applyCheckOutHouse")
    @SysControllerFilter(name = "applyCheckOutHouse")
    @ResponseBody
    public String applyCheckOutHouse(String id) throws Exception {
        return houseCzqkService.applyCheckOutHouse(Integer.parseInt(id));
    }

    @RequestMapping(value = "/selectTeacherBySession")
    @SysControllerFilter(name = "selectTeacherBySession")
    @ResponseBody
    public String selectTeacherBySession(String jggh) throws Exception {
        Teacher teacher1 = new Teacher();
        teacher1.setJggh(jggh);
        Teacher teacher = teacherMapper.selectOne(teacher1);
        if(!ObjectUtils.isEmpty(teacher)) {
            return JSON.toJSONString(teacher);
        }else {
            return "error";
        }
    }

    @RequestMapping(value = "/selectTeacherHouseToCzqkById")
    @SysControllerFilter(name = "selectTeacherHouseToCzqkById")
    public ModelAndView selectTeacherHouseToCzqkById(ModelAndView modelAndView, String id) throws Exception {
        return houseCzqkService.selectTeacherHouseToCzqkById(modelAndView, Integer.parseInt(id));
    }

    @RequestMapping(value = "/addTeacherHouseCzqk")
    @SysControllerFilter(name = "addTeacherHouseCzqk")
    @ResponseBody
    public String addTeacherHouseCzqk(HouseCzqk houseCzqk) throws Exception {
        return houseCzqkService.addTeacherHouseCzqk(houseCzqk);
    }
}


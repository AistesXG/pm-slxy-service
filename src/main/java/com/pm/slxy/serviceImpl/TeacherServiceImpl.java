package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.TeacherRentalStatusEnum;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.TeacherService;
import com.pm.slxy.utils.JodaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-26
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {


    @Autowired
    private TeacherMapper teacherMapper;


    /**
     * 查找所有教师信息
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectTeachers(ModelAndView modelAndView) {
        List<Teacher> teacherList = teacherMapper.selectList(new EntityWrapper<Teacher>());
        modelAndView.addObject("teacherList", teacherList);
        modelAndView.setViewName("/teacher/teacherDetails");
        return modelAndView;
    }

    /**
     * 批量删除+单个删除
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteTeacherByIds(String ids) {
        List<String> teacherIds = Arrays.asList(ids.split(","));
        List<Teacher> teacherList = teacherMapper.selectBatchIds(teacherIds);
        if (teacherList.get(0).getZfzt().equals(TeacherRentalStatusEnum.ALREADY_RENTAL_HOUSE.getStatus())) {
            return "该教师已经租房了，不能够直接删除";
        }
        int deleteTeacher = teacherMapper.deleteBatchIds(teacherIds);
        if (deleteTeacher != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 添加教师信息
     *
     * @param teacher
     * @return
     */
    @Override
    public String addTeacher(Teacher teacher) {
        teacher.setZfzt(TeacherRentalStatusEnum.NOT_RENTAL_HOUSE.getStatus());
        if (StringUtils.isEmpty(teacher.getXm())
                || StringUtils.isEmpty(teacher.getCjgzrq())
                || StringUtils.isEmpty(teacher.getCsrq())
                || StringUtils.isEmpty(teacher.getJg())
                || StringUtils.isEmpty(teacher.getJggh())
                || StringUtils.isEmpty(teacher.getSzbm())
                || StringUtils.isEmpty(teacher.getZfzt())
                || StringUtils.isEmpty(teacher.getXb())
                || StringUtils.isEmpty(teacher.getXl())
                || StringUtils.isEmpty(teacher.getSfzh())) {
            return "输入的信息不能为空！";
        }
        teacher.setSqzfrq(JodaTimeUtils.formatDateNow());
        if (this.insert(teacher)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 更新教师信息
     *
     * @param teacher
     * @return
     */
    @Override
    public String updateTeacher(Teacher teacher) {
        if (StringUtils.isEmpty(teacher.getXm())
                || StringUtils.isEmpty(teacher.getCjgzrq())
                || StringUtils.isEmpty(teacher.getCsrq())
                || StringUtils.isEmpty(teacher.getJg())
                || StringUtils.isEmpty(teacher.getJggh())
                || StringUtils.isEmpty(teacher.getSzbm())
                || StringUtils.isEmpty(teacher.getZfzt())
                || StringUtils.isEmpty(teacher.getXb())
                || StringUtils.isEmpty(teacher.getXl())
                || StringUtils.isEmpty(teacher.getSfzh())) {
            return "输入的信息不能为空！";
        }

        Teacher oldTeacher = this.selectById(teacher.getId());
        if (teacher.getSfzh().equals(oldTeacher.getSfzh())) {
            teacher.setSfzh(oldTeacher.getSfzh());
        }
        if (teacher.getJggh().equals(oldTeacher.getJggh())) {
            teacher.setJggh(oldTeacher.getJggh());
        } else {
            Teacher teacher1 = new Teacher();
            teacher1.setJggh(teacher.getJggh());
            Teacher teacher2 = this.selectOne(new EntityWrapper<>(teacher1));
            Teacher teacher3 = new Teacher();
            teacher3.setSfzh(teacher.getSfzh());
            Teacher teacher4 = this.selectOne(new EntityWrapper<>(teacher3));
            if (teacher2 != null) {
                return "教工编号已经被使用了";
            }
            if (teacher4 != null) {
                return "身份证号已经被使用了";
            }
        }
        teacher.setSqzfrq(JodaTimeUtils.formatDateNow());
        if (this.updateById(teacher)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 根据id来查找一个教师信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectTeacher(ModelAndView modelAndView, int id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (!ObjectUtils.isEmpty(teacher)) {
            modelAndView.addObject("teacher", teacher);
            modelAndView.setViewName("teacher/updateTeacher");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 检测更新或者添加的时候数据库中是否已经存在了教师的编号
     *
     * @param jggh
     * @return
     */
    @Override
    public Map<String, Boolean> checkTeacherNum(String jggh) {
        boolean result = true;
        Teacher teacher = new Teacher();
        teacher.setJggh(jggh);
        List<Teacher> teachers = teacherMapper.selectList(new EntityWrapper<>(teacher));
        for (Teacher teacher1 : teachers) {
            if (teacher1.getJggh().equals(jggh)) {
                result = false;
                break;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;
    }

    /**
     * 检测更新或者添加的时候数据库中是否已经存在了教师的身份证号
     *
     * @param sfzh
     * @return
     */
    @Override
    public Map<String, Boolean> checkTeacherIdCard(String sfzh) {
        boolean result = true;
        Teacher teacher = new Teacher();
        teacher.setSfzh(sfzh);
        List<Teacher> teachers = teacherMapper.selectList(new EntityWrapper<>(teacher));
        for (Teacher teacher1 : teachers) {
            if (teacher1.getSfzh().equals(sfzh)) {
                result = false;
                break;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;
    }

    /**
     * 查找所有部门
     *
     * @return
     */
    @Override
    public List<String> selectDepartment() {
        List<String> departments = teacherMapper.selectDepartment();
        if (!CollectionUtils.isEmpty(departments)) {
            return departments;
        } else {
            return null;
        }
    }

    /**
     * 根据id查看一个教师的详情
     *
     * @param id
     * @return
     */
    @Override
    public String selectTeacherById(int id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (!ObjectUtils.isEmpty(teacher)) {
            return JSON.toJSONString(teacher);
        } else {
            return "error";
        }
    }
}

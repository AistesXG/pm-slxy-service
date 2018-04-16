package com.pm.slxy.serviceImpl;

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

import java.util.Arrays;
import java.util.List;

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
 //           modelAndView.addObject("deptList", departmentMapper.selectList(new EntityWrapper<Department>()));
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
    public String checkTeacherNum(String jggh) {
        if (StringUtils.isEmpty(jggh)) {
            return "error";
        }
        Teacher teacher = new Teacher();
        teacher.setJggh(jggh);
        List<Teacher> teachers = teacherMapper.selectList(new EntityWrapper<>(teacher));
        if (CollectionUtils.isEmpty(teachers)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 检测更新或者添加的时候数据库中是否已经存在了教师的身份证号
     *
     * @param sfzh
     * @return
     */
    @Override
    public String checkTeacheridCard(String sfzh) {
        if (StringUtils.isEmpty(sfzh)) {
            return "error";
        }
        Teacher teacher = new Teacher();
        teacher.setSfzh(sfzh);
        List<Teacher> teachers = teacherMapper.selectList(new EntityWrapper<>(teacher));
        if (CollectionUtils.isEmpty(teachers)) {
            return "ok";
        } else {
            return "error";
        }
    }
}

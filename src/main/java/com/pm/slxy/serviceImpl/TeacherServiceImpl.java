package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.TeacherService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
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
        if (StringUtils.isEmpty(teacher.getTeachername())
                || StringUtils.isEmpty(teacher.getTeacherbirthdate())
                || StringUtils.isEmpty(teacher.getTeacheridcard())
                || StringUtils.isEmpty(teacher.getTeachernumber())
                || StringUtils.isEmpty(teacher.getTeacherdepartment())
                || StringUtils.isEmpty(teacher.getTeachereducation())
                || StringUtils.isEmpty(teacher.getTeacherhousingdate())
                || StringUtils.isEmpty(teacher.getTeacherplaceorigin())
                || StringUtils.isEmpty(teacher.getTeacherrentalstatus())
                || StringUtils.isEmpty(teacher.getTeachersex())
                || StringUtils.isEmpty(teacher.getTeacherstartwork())) {
            return "输入的信息不能为空！";
        }
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
        if (StringUtils.isEmpty(teacher.getTeachername())
                || StringUtils.isEmpty(teacher.getTeacherbirthdate())
                || StringUtils.isEmpty(teacher.getTeacheridcard())
                || StringUtils.isEmpty(teacher.getTeachernumber())
                || StringUtils.isEmpty(teacher.getTeacherdepartment())
                || StringUtils.isEmpty(teacher.getTeachereducation())
                || StringUtils.isEmpty(teacher.getTeacherhousingdate())
                || StringUtils.isEmpty(teacher.getTeacherplaceorigin())
                || StringUtils.isEmpty(teacher.getTeacherrentalstatus())
                || StringUtils.isEmpty(teacher.getTeachersex())
                || StringUtils.isEmpty(teacher.getTeacherstartwork())) {
            return "输入的信息不能为空！";
        }
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
     * @param teachernumber
     * @return
     */
    @Override
    public String checkTeacherNum(String teachernumber) {
        if (StringUtils.isEmpty(teachernumber)) {
            return "error";
        }
        Teacher teacher = new Teacher();
        teacher.setTeachernumber(teachernumber);
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
     * @param teacheridcard
     * @return
     */
    @Override
    public String checkTeacheridCard(String teacheridcard) {
        if (StringUtils.isEmpty(teacheridcard)) {
            return "error";
        }
        Teacher teacher = new Teacher();
        teacher.setTeacheridcard(teacheridcard);
        List<Teacher> teachers = teacherMapper.selectList(new EntityWrapper<>(teacher));
        if (CollectionUtils.isEmpty(teachers)) {
            return "ok";
        } else {
            return "error";
        }
    }
}

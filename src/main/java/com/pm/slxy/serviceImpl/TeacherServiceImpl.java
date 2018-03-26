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
            return "录入信息有误！";
        }
        Teacher teacher1 = new Teacher();
        teacher1.setTeachername(teacher.getTeachername());
        Teacher teacher2 = this.selectOne(new EntityWrapper<>(teacher1));
        if (!ObjectUtils.isEmpty(teacher2)) {
            return "教师已经存在！";
        }

        if (this.insert(teacher)) {
            return "ok";
        } else {
            return "error";
        }
    }
}

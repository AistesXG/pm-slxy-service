package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.Teacher;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-26
 */
public interface TeacherService extends IService<Teacher> {
    /**
     * 查找所有教师信息
     *
     * @return
     */
    ModelAndView selectTeachers(ModelAndView modelAndView);
    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    String deleteTeacherByIds(String ids);


    /**
     * 添加教师
     *
     * @param teacher
     * @return
     */
    String addTeacher(Teacher teacher);
}

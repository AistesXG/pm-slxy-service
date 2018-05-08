package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.deserializer.CollectionResolveFieldDeserializer;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        modelAndView.addObject("departments", this.selectDepartment());
        modelAndView.setViewName("teacher/teacherList");
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
        teacher.setSqzfrq("0000-00-00");
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
        if (oldTeacher.getZfzt().equals("未租")) {
            teacher.setSqzfrq("0000-00-00");
        } else {
            teacher.setSqzfrq(oldTeacher.getSqzfrq());
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
            modelAndView.addObject("departments", teacherMapper.selectDepartment());
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
    public ModelAndView selectTeacherById(ModelAndView modelAndView, int id) {
        Teacher teacher = teacherMapper.selectById(id);
        if (!ObjectUtils.isEmpty(teacher)) {
            modelAndView.addObject("teacher", teacher);
            modelAndView.setViewName("/teacher/teacherDetails");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 根据部门搜索教师信息
     *
     * @param szbm
     * @return
     */
    @Override
    public ModelAndView selectTeacherByDept(ModelAndView modelAndView, String szbm) {
        Teacher teacher = new Teacher();
        teacher.setSzbm(szbm);
        return getModelAndView(modelAndView, teacher);
    }

    /**
     * 根据教师租住状态查找教师信息
     *
     * @param modelAndView
     * @param zfzt
     * @return
     */
    @Override
    public ModelAndView selectTeacherByStatus(ModelAndView modelAndView, String zfzt) {
        Teacher teacher = new Teacher();
        teacher.setZfzt(zfzt);
        return getModelAndView(modelAndView, teacher);
    }

    /**
     * 根据教师所在部门查找教师的编号
     *
     * @param szbm
     * @return
     */
    @Override
    public String selectTeacherZzjsbhByDept(String szbm) {
        List<String> jgghList = teacherMapper.selectTeacherZzjsbhByDept(szbm);
        if (!CollectionUtils.isEmpty(jgghList)) {
            return JSON.toJSONString(jgghList);
        }
        return "error";
    }

    /**
     * 根据教师的编号查找教师的姓名
     *
     * @param jggh
     * @return
     */
    @Override
    public String selectTeacherXmByJggh(String jggh) {
        String xm = teacherMapper.selectTeacherXmByJggh(jggh);
        if (!StringUtils.isEmpty(xm)) {
            return JSON.toJSONString(xm);
        }
        return "error";
    }

//    /**
//     * 查找教师部门教师姓名
//     *
//     * @param szbm
//     * @return
//     */
//    @Override
//    public String selectTeacherXmByDept(String szbm) {
//        List<String> xmList = teacherMapper.selectTeacherXmByDept(szbm);
//        if (!CollectionUtils.isEmpty(xmList)) {
//            return JSON.toJSONString(xmList);
//        }
//        return null;
//    }

    /**
     * 根据字段查找教师信息的方法
     *
     * @param modelAndView
     * @param teacher
     * @return
     */
    private ModelAndView getModelAndView(ModelAndView modelAndView, Teacher teacher) {
        List<Teacher> teacherList = teacherMapper.selectList(new EntityWrapper<>(teacher));
        if (!CollectionUtils.isEmpty(teacherList)) {
            modelAndView.addObject("departments", this.selectDepartment());
            modelAndView.addObject("teacherList", teacherList);
            modelAndView.setViewName("teacher/teacherList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
}
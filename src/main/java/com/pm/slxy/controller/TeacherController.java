package com.pm.slxy.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.service.TeacherService;
import com.pm.slxy.utils.SysControllerFilter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.IntrospectionException;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.HashMap;
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

    @RequestMapping(value = "/selectTeacherZzjsbhByDept", produces = "application/json;charset=utf-8")
    @SysControllerFilter(name = "selectTeacherZzjsbhByDept")
    @ResponseBody
    public String selectTeacherXmByDept(String szbm) throws Exception {
        return teacherService.selectTeacherZzjsbhByDept(szbm);
    }

    @RequestMapping(value = "/selectTeacherXmByJggh", produces = "application/json;charset=utf-8")
    @SysControllerFilter(name = "selectTeacherXmByJggh")
    @ResponseBody
    public String selectTeacherXmByJggh(String jggh) throws Exception {
        return teacherService.selectTeacherXmByJggh(jggh);
    }

    @RequestMapping("/exportTeacherToExcel")
    @SysControllerFilter(name = "exportTeacherToExcel")
    @ResponseBody
    public void exportTeacherToExcel(HttpServletResponse response) throws ClassNotFoundException, IntrospectionException, IllegalAccessException, ParseException, InvocationTargetException {
        String ExcelName = "teacher";
        if (ExcelName != "") {
            response.reset(); //清除buffer缓存
            // 指定下载的文件名
            response.setHeader("Content-Disposition", "attachment;filename=" + ExcelName + ".xlsx");
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            XSSFWorkbook workbook;
            //导出Excel对象
            workbook = teacherService.exportExcelInfo();
            OutputStream output;
            try {
                output = response.getOutputStream();
                BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
                bufferedOutPut.flush();
                workbook.write(bufferedOutPut);
                bufferedOutPut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RequestMapping("/importExcelTeacher")
    @SysControllerFilter(name = "importExcelTeacher")
    @ResponseBody
    public String importExcelTeacher(HttpServletRequest request) throws Exception {
        //获取上传的文件
        MultipartHttpServletRequest multipart = (MultipartHttpServletRequest) request;
        MultipartFile file = multipart.getFile("excelFile");
        InputStream in = file.getInputStream();
        //数据导入
        teacherService.importExcelInfo(in, file);
        in.close();
        return JSON.toJSONString("导入成功");
    }
}


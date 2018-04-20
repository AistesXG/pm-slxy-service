package com.pm.slxy.utils;

import com.pm.slxy.entity.Teacher;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Excel文件导出工具类
 *
 * @author furg@senthink.com
 * @date 2018/4/19
 */
public class ExcelExportUtils {

    private ExcelExportUtils() {
    }

    /**
     * 将老师信息导出到Excel文件
     *
     * @param savePath
     * @param teachers
     * @return
     * @throws Exception
     */
    public static String exportTeacherToExcel(String savePath, List<Teacher> teachers) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook(); //Excel文件
        XSSFSheet sheet = workbook.createSheet(); //创建一个Excel工作簿（Sheet）
        int rowIndex = 0;
        XSSFRow columnNameRow = sheet.createRow(rowIndex++); // 使用Excel工作簿（Sheet）中的第一行来设置列的名称
        //设置列名称
        List<String> columnNames = new LinkedList<>();
        columnNames.add("教师姓名");
        columnNames.add("教工编号");
        columnNames.add("性别");
        columnNames.add("身份证号码");
        columnNames.add("出生年月");
        columnNames.add("学历");
        columnNames.add("参加工作时间");
        columnNames.add("申请住房日期");
        columnNames.add("所在部门");
        columnNames.add("籍贯");
        columnNames.add("租房状态");
        for (int i = 0; i < columnNames.size(); i++) {
            XSSFCell cell = columnNameRow.createCell(i);  //创建单元格
            cell.setCellValue(columnNames.get(i));   //为单元格设置值
        }

        for (int i = 0; i < teachers.size(); i++) {
            int columnIndex = 0;
            XSSFRow valueRow = sheet.createRow(rowIndex++);
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getXm());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getJggh());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getXb());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getSfzh());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getCsrq());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getXl());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getCjgzrq());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getSqzfrq());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getSzbm());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getJg());
            valueRow.createCell(columnIndex++).setCellValue(teachers.get(i).getZfzt());
        }
        String path = savePath + File.separator;
        String name = "Teachers" + ".xlsx";
        String filePath = path + name;
        FileOutputStream outputStream = new FileOutputStream(filePath);
        workbook.write(outputStream);
        outputStream.close();
        workbook.close();
        return name;
    }
}

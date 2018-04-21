package com.pm.slxy.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理Excel文件的工具类
 *
 * @author zooqi@senthink.com
 * @date 2017/11/30
 */
public final class ExcelUtils {

    private static final String XLS = "xls";

    private static final String XLSX = "xlsx";

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private static final SimpleDateFormat TIME_FORMAT = new SimpleDateFormat("HH:mm:ss");

    private ExcelUtils() {
    }

    /**
     * 通过MultipartFile对象构建Workbook对象
     *
     * @param file
     * @return
     */
    public static Workbook buildWorkbook(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException();
        }

        Workbook workbook;
        try {
            String extension = FilenameUtils.getExtension(file.getOriginalFilename());
            if (XLS.equalsIgnoreCase(extension)) {
                workbook = new HSSFWorkbook(file.getInputStream());
            } else if (XLSX.equalsIgnoreCase(extension)) {
                workbook = new XSSFWorkbook(file.getInputStream());
            } else {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
        return workbook;
    }

    /**
     * 检测Excel中某行是否没有内容(即此行的单元格是否全为CellType.BLANK类型)
     *
     * @param row
     * @return
     */
    public static boolean blankRow(Row row) {
        if (row == null) {
            return true;
        }
        for (int i = row.getFirstCellNum(); i <= row.getLastCellNum(); i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellTypeEnum() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    /**
     * 检测Excel中某些单元格中是否存在CellType.BLANK类型
     *
     * @param cells
     * @return
     */
    public static boolean anyCellBlank(Cell... cells) {
        for (int i = 0; i < cells.length; i++) {
            if (cells[i] == null || cells[i].getCellTypeEnum() == CellType.BLANK) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检测单元格是否为空(null 或者 CellType.BLANK)
     *
     * @param cell
     * @return
     */
    public static boolean blankCell(Cell cell) {
        return cell == null || cell.getCellTypeEnum() == CellType.BLANK;
    }

    /**
     * 从单元格中读取日期/时间
     *
     * @param cell 单元格
     * @param date 是否读取日期(true: yyyy-MM-dd, false: HH:mm:ss)
     * @return
     */
    public static Date getDate(Cell cell, boolean date) {
        if (cell.getCellTypeEnum() == CellType.STRING) {
            try {
                if (date) {
                    return DATE_FORMAT.parse(cell.getStringCellValue());
                }
                return TIME_FORMAT.parse(cell.getStringCellValue());
            } catch (ParseException e) {
                throw new IllegalArgumentException(e);
            }
        } else if (DateUtil.isCellDateFormatted(cell)) {
            cell.setCellType(CellType.NUMERIC);
            return cell.getDateCellValue();
        } else {
            throw new IllegalArgumentException();
        }
    }
}

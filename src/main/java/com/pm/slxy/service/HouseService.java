package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.House;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-17
 */
public interface HouseService extends IService<House> {
    /**
     * 查找教师用房房产信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHouses(ModelAndView modelAndView);

    /**
     * 添加教师用房
     *
     * @param house
     * @return
     */
    String addHouse(House house);

    /**
     * 更新教师房产信息
     *
     * @param house
     * @return
     */
    String updateHouse(House house);

    /**
     * 根据id来查找一个教师教师用房信息并转到updateHouse页面
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectHouseById(ModelAndView modelAndView, int id);

    /**
     * 删除教师房产信息（支持批量删除和单个删除）
     *
     * @param ids
     * @return
     */
    String deleteHouseByIds(String ids);

    /**
     * 在教师房屋的图片详情页面点击一个图片显示的数据
     *
     * @param id
     * @return
     */
    String selectHouseDetailById(int id);

    /**
     * 检查房间编号是否存在
     *
     * @param fjbh
     * @return
     */
    Map<String, Boolean> checkHouseBh(String fjbh);

    /**
     * 按照租住状态查找教师租房的房屋信息
     *
     * @param modelAndView
     * @param zzzt
     * @return
     */
    ModelAndView selectHouseByStatus(ModelAndView modelAndView, String zzzt);

    /**
     * 退房
     *
     * @param id
     * @return
     */
    String checkOutHouse(int id);

    /**
     * 计算费用
     * @param modelAndView
     * @param startTime
     * @param endTime
     * @return
     */
    ModelAndView Calculation(ModelAndView modelAndView, String startTime, String endTime) throws Exception;

    /**
     * 导出教师信息
     *
     * @return
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws IntrospectionException
     * @throws ParseException
     * @throws IllegalAccessException
     */
    XSSFWorkbook exportPriceToExcel(String startTime, String endTime) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException;
}

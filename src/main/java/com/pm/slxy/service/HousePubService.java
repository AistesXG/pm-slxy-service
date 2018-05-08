package com.pm.slxy.service;

import com.pm.slxy.entity.HousePub;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * <p>
 * 房产信息服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-03
 */
public interface HousePubService extends IService<HousePub> {

    /**
     * 查找公用房房产信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHousePubs(ModelAndView modelAndView);


    /**
     * 添加公用房房产信息
     *
     * @param housePub
     * @return
     */
    String addHousePub(HousePub housePub);


    /**
     * 删除公用房房产信息（支持批量删除和单个删除）
     *
     * @param ids
     * @return
     */
    String deleteHousePubByIds(String ids);

    /**
     * 根据id来查找一个公用房房产信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectHousePubById(ModelAndView modelAndView, int id);

    /**
     * 更新公用房房产信息
     *
     * @param housePub
     * @return
     */
    String updateHousePub(HousePub housePub);

    /**
     * 在公用房房屋的图片详情页面点击一个图片显示的数据
     *
     * @param id
     * @return
     */
    String selectHousePubDetailById(int id);

    /**
     * 按照租住状态查找教师租房的房屋信息
     *
     * @param modelAndView
     * @param fjsyzt
     * @return
     */
    ModelAndView selectHousePubByStatus(ModelAndView modelAndView, String fjsyzt);

    /**
     * 检查房间编号是否存在
     *
     * @param fjbh
     * @return
     */
    Map<String, Boolean> checkHousePubBh(String fjbh);
}

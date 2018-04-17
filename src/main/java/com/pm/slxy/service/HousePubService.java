package com.pm.slxy.service;

import com.pm.slxy.entity.HousePub;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.web.servlet.ModelAndView;

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
     * 查找房产信息
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHousePubs(ModelAndView modelAndView);


    /**
     * 添加房产信息
     *
     * @param housePub
     * @return
     */
    String addHousePub(HousePub housePub);


    /**
     * 删除房产信息（支持批量删除和单个删除）
     *
     * @param ids
     * @return
     */
    String deleteHousePubByIds(String ids);

    /**
     * 根据id来查找一个房产信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectHousePubById(ModelAndView modelAndView, int id);

    /**
     * 更新房产信息
     *
     * @param housePub
     * @return
     */
    String updateHousePub(HousePub housePub);

    /**
     * 在房屋的图片详情页面点击一个图片显示的数据
     *
     * @param id
     * @return
     */
    String selectHousePubDetailById(int id);

}

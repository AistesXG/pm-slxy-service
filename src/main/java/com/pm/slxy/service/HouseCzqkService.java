package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.HouseCzqk;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-06
 */
public interface HouseCzqkService extends IService<HouseCzqk> {

    /**
     * 查找租房情况详情
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectHouseCzqks(ModelAndView modelAndView);

    /**
     * 根据id查找教师用房房屋信息渲染到HouseCzqk页面
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectHouseToCzqkById(ModelAndView modelAndView, int id);

    /**
     * 添加教师租房房屋的住房情况
     *
     * @param houseCzqk
     * @return
     */
    String addHouseCzqk(HouseCzqk houseCzqk);

    /**
     * 根据id来查找房屋租住情况的详细信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectHouseCzqkById(ModelAndView modelAndView, int id);
}

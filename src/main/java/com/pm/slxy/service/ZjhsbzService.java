package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.Zjhsbz;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-28
 */
public interface ZjhsbzService extends IService<Zjhsbz> {

    /**
     * 查找访问价格的列表
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectPrice(ModelAndView modelAndView);

    /**
     * 更加id来查找价格信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    ModelAndView selectPriceById(ModelAndView modelAndView, int id);

    /**
     * 更新房屋价格信息
     *
     * @param zjhsbz
     * @return
     */
    String updatePrice(Zjhsbz zjhsbz);
}

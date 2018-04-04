package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.service.HousePubService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-03
 */
@Service
public class HousePubServiceImpl extends ServiceImpl<HousePubMapper, HousePub> implements HousePubService {

    @Autowired
    private HousePubMapper housePubMapper;

    /**
     * 查找房产信息
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectHouses(ModelAndView modelAndView) {
        List<HousePub> housePubList = housePubMapper.selectList(new EntityWrapper<HousePub>());
        modelAndView.addObject("housePubList", housePubList);
        modelAndView.setViewName("/house/houseDetails");
        return modelAndView;
    }
}

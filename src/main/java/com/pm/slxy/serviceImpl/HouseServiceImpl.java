package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.House;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.service.HouseService;
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
 * @since 2018-04-17
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    /**
     * 查找教师用房的房产信息
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectHouses(ModelAndView modelAndView) {
        List<House> houseList = houseMapper.selectList(new EntityWrapper<House>());
        modelAndView.addObject("houseList", houseList);
        modelAndView.setViewName("house/houseDetails");
        return modelAndView;
    }
}

package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.entity.Zjhsbz;
import com.pm.slxy.mapper.ZjhsbzMapper;
import com.pm.slxy.service.ZjhsbzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-28
 */
@Service
public class ZjhsbzServiceImpl extends ServiceImpl<ZjhsbzMapper, Zjhsbz> implements ZjhsbzService {

    @Autowired
    private ZjhsbzMapper zjhsbzMapper;

    /**
     * 查找房屋价格的信息
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectPrice(ModelAndView modelAndView) {
        List<Zjhsbz> list = zjhsbzMapper.selectList(new EntityWrapper<Zjhsbz>());
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/housePrice/housePriceDetail");
        return modelAndView;
    }

    @Override
    public ModelAndView selectPriceById(ModelAndView modelAndView, int id) {
        Zjhsbz zjhsbz = zjhsbzMapper.selectById(id);
        if (!ObjectUtils.isEmpty(zjhsbz)) {
            modelAndView.addObject("housePrice", zjhsbz);
            modelAndView.setViewName("/housePrice/updatePrice");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 更新房屋价格
     *
     * @param zjhsbz
     * @return
     */
    @Override
    public String updatePrice(Zjhsbz zjhsbz) {
        if (this.updateById(zjhsbz)) {
            return "ok";
        }
        return "error";
    }
}

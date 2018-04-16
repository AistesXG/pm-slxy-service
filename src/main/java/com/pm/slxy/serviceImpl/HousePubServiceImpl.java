package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.service.HousePubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
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
    public ModelAndView selectHousePubs(ModelAndView modelAndView) {
        List<HousePub> housePubList = housePubMapper.selectList(new EntityWrapper<HousePub>());
        modelAndView.addObject("housePubList", housePubList);
        modelAndView.setViewName("housePub/housePubDetails");
        return modelAndView;
    }

    /**
     * 添加housePub
     *
     * @param housePub
     * @return
     */
    @Override
    public String addHousePub(HousePub housePub) {
        if (StringUtils.isEmpty(housePub.getFjbh()) ||
                StringUtils.isEmpty(housePub.getFjlh()) ||
                StringUtils.isEmpty(housePub.getFjmj()) ||
                StringUtils.isEmpty(housePub.getFjsybm())||
                StringUtils.isEmpty(housePub.getFjsylx()) ||
                StringUtils.isEmpty(housePub.getFjsyzt())
                ) {
            return "输入的信息不能为空！";
        }
        if (this.insert(housePub)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 删除housePub数据
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteHousePubByIds(String ids) {
        List<String> housePubs = Arrays.asList(ids.split(","));
        List<HousePub> housePubList = housePubMapper.selectBatchIds(housePubs);
        if (housePubList.get(0).getFjsyzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus())) {
            return "您删除的房子已经租出去了";
        }
        int deleteHousePub = housePubMapper.deleteBatchIds(housePubs);
        if (deleteHousePub != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 根据id来查找一个房产的信息
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectHousePubById(ModelAndView modelAndView, int id) {
        HousePub housePub = housePubMapper.selectById(id);
        if (!ObjectUtils.isEmpty(housePub)) {
            modelAndView.addObject("housePub", housePub);
            modelAndView.setViewName("housePub/updateHousePub");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 更新房产信息
     *
     * @param housePub
     * @return
     */
    @Override
    public String updateHousePub(HousePub housePub) {
        if (StringUtils.isEmpty(housePub.getFjbh()) ||
                StringUtils.isEmpty(housePub.getFjlh()) ||
                StringUtils.isEmpty(housePub.getFjmj()) ||
                StringUtils.isEmpty(housePub.getFjsybm())||
                StringUtils.isEmpty(housePub.getFjsylx()) ||
                StringUtils.isEmpty(housePub.getFjsyzt())
                ) {
            return "输入的信息不能为空！";
        }
        if (this.updateById(housePub)) {
            return "ok";
        } else {
            return "error";
        }
    }

}

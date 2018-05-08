package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HousePubStatusEnum;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HousePubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 查找公用房房产信息
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
     * 添加公用房housePub
     *
     * @param housePub
     * @return
     */
    @Override
    public String addHousePub(HousePub housePub) {
        housePub.setFjsyzt(HousePubStatusEnum.FREE.getStatus());
        if (StringUtils.isEmpty(housePub.getFjbh()) ||
                StringUtils.isEmpty(housePub.getFjlh()) ||
                StringUtils.isEmpty(housePub.getFjmj()) ||
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
     * 删除公用房housePub数据
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteHousePubByIds(String ids) {
        List<String> housePubs = Arrays.asList(ids.split(","));
        List<HousePub> housePubList = housePubMapper.selectBatchIds(housePubs);
        if (housePubList.get(0).getFjsyzt().equals(HousePubStatusEnum.IN_USE.getStatus())) {
            return "您删除的房子正在使用";
        }
        int deleteHousePub = housePubMapper.deleteBatchIds(housePubs);
        if (deleteHousePub != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 根据id来查找一个公用房房产的信息
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
            modelAndView.addObject("departments", teacherMapper.selectDepartment());
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }


    /**
     * 更新公用房房产信息
     *
     * @param housePub
     * @return
     */
    @Override
    public String updateHousePub(HousePub housePub) {
        if (StringUtils.isEmpty(housePub.getFjbh()) ||
                StringUtils.isEmpty(housePub.getFjlh()) ||
                StringUtils.isEmpty(housePub.getFjmj()) ||
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

    /**
     * 在公用房房屋的图片详情页面点击一个图片显示的数据
     *
     * @param id
     * @return
     */
    @Override
    public String selectHousePubDetailById(int id) {
        HousePub housePubDetail = housePubMapper.selectById(id);
        if (!ObjectUtils.isEmpty(housePubDetail)) {
            return JSON.toJSONString(housePubDetail);
        } else {
            return "error";
        }
    }

    /**
     * 按照租住状态查找公用房屋的信息
     *
     * @param modelAndView
     * @param fjsyzt
     * @return
     */
    @Override
    public ModelAndView selectHousePubByStatus(ModelAndView modelAndView, String fjsyzt) {
        HousePub housePub = new HousePub();
        housePub.setFjsyzt(fjsyzt);
        List<HousePub> housePubList = housePubMapper.selectList(new EntityWrapper<>(housePub));
        if (!CollectionUtils.isEmpty(housePubList)) {
            modelAndView.addObject("housePubList", housePubList);
            modelAndView.setViewName("housePub/housePubDetails");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 检测房间编号是否在数据库中已经存在了
     *
     * @param fjbh
     * @return
     */
    @Override
    public Map<String, Boolean> checkHousePubBh(String fjbh) {
        boolean result = true;
        HousePub housePub = new HousePub();
        housePub.setFjbh(fjbh);
        List<HousePub> housePubs = housePubMapper.selectList(new EntityWrapper<>(housePub));
        for (HousePub housePub1 : housePubs) {
            if (housePub1.getFjbh().equals(fjbh)) {
                result = false;
                break;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;
    }

}

package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.House;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseService;
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
 * @since 2018-04-17
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private TeacherMapper teacherMapper;

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

    /**
     * 添加教师用房信息
     *
     * @param house
     * @return
     */
    @Override
    public String addHouse(House house) {
        house.setZzzt(HouseStatusEnum.NOT_RENTAL.getStatus());
        if (StringUtils.isEmpty(house.getZzzxm())
                || StringUtils.isEmpty(house.getFjbh())
                || StringUtils.isEmpty(house.getFjlh())
                || StringUtils.isEmpty(house.getFjmj())) {
            return "输入的信息不能为空！";
        }
        if (this.insert(house)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 更新教师用房信息
     *
     * @param house
     * @return
     */
    @Override
    public String updateHouse(House house) {
        if (StringUtils.isEmpty(house.getZzzxm())
                || StringUtils.isEmpty(house.getFjbh())
                || StringUtils.isEmpty(house.getFjlh())
                || StringUtils.isEmpty(house.getFjmj())) {
            return "输入的信息不能为空！";
        }
        if (this.updateById(house)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 根据id来查找一个教师教师用房信息并转到updateHouse页面
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectHouseById(ModelAndView modelAndView, int id) {
        House house = houseMapper.selectById(id);
        if (!ObjectUtils.isEmpty(house)) {
            modelAndView.addObject("house", house);
            modelAndView.addObject("departments", teacherMapper.selectDepartment());
            modelAndView.setViewName("house/updateHouse");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;

    }

    /**
     * 删除教师用房信息（支持单个删除和批量删除）
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteHouseByIds(String ids) {
        List<String> houses = Arrays.asList(ids.split(","));
        List<House> houseList = houseMapper.selectBatchIds(houses);
        if (houseList.get(0).getZzzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus())) {
            return "您删除的房子已经租出去了";
        }
        int deleteHousePub = houseMapper.deleteBatchIds(houses);
        if (deleteHousePub != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 在教师房屋的图片详情页面点击一个图片显示的数据
     *
     * @param id
     * @return
     */
    @Override
    public String selectHouseDetailById(int id) {
        House houseDetail = houseMapper.selectById(id);
        if (!ObjectUtils.isEmpty(houseDetail)) {
            return JSON.toJSONString(houseDetail);
        } else {
            return "error";
        }
    }
}

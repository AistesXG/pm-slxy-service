package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseApplyEnum;
import com.pm.slxy.Enum.HouseCzqkStatusEnum;
import com.pm.slxy.Enum.HouseCzqkZXTHouseStatusEnum;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.House;
import com.pm.slxy.entity.HouseCzqk;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.HouseCzqkMapper;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseService;
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
 * @since 2018-04-17
 */
@Service
public class HouseServiceImpl extends ServiceImpl<HouseMapper, House> implements HouseService {

    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private HouseCzqkMapper houseCzqkMapper;

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
        modelAndView.setViewName("house/houseList");
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
        house.setApply(HouseApplyEnum.NOT_APPLY_ENUM.getStatus());
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
        House oldHouse = this.selectById(house.getId());
        if (house.getFjbh().equals(oldHouse.getFjbh())) {
            house.setFjbh(oldHouse.getFjbh());
        } else {
            House house1 = new House();
            house1.setFjbh(house.getFjbh());
            House house2 = this.selectOne(new EntityWrapper<>(house1));
            if (house2 != null) {
                return "房间编号已经被使用了!";
            }
        }
        //如果租住状态为已租的话，更新租住情况列表中的数据
        if (house.getZzzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus()) || house.getZzzt().equals(HouseStatusEnum.APPLY_RENTAL.getStatus()) || house.getZzzt().equals(HouseStatusEnum.CHECK_OUT_HOUSE.getStatus())) {
            //更新房屋租出情况表中对应的数据
            HouseCzqk houseCzqk = new HouseCzqk();
            houseCzqk.setFjbh(oldHouse.getFjbh());
            HouseCzqk houseCzqk1 = houseCzqkMapper.selectOne(houseCzqk);
            houseCzqk1.setFjlh(house.getFjlh());
            houseCzqk1.setFjbh(house.getFjbh());
            houseCzqk1.setFjmj(house.getFjmj());
            houseCzqkMapper.updateById(houseCzqk1);
        }
        if (this.updateById(house)) {
            return "ok";
        }
        return "error";
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
        if (houseList.get(0).getZzzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus()) || houseList.get(0).getZzzt().equals(HouseStatusEnum.APPLY_RENTAL.getStatus()) ||  houseList.get(0).getZzzt().equals(HouseStatusEnum.CHECK_OUT_HOUSE.getStatus())) {
            return "您删除的房子已经租出去了,申请退房或者被续租了";
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

    /**
     * 添加房屋的时候检测房间编号是否已经存在
     *
     * @param fjbh
     * @return
     */
    @Override
    public Map<String, Boolean> checkHouseBh(String fjbh) {
        boolean result = true;
        House house = new House();
        house.setFjbh(fjbh);
        List<House> houses = houseMapper.selectList(new EntityWrapper<>(house));
        for (House house1 : houses) {
            if (house1.getFjbh().equals(fjbh)) {
                result = false;
                break;
            }
        }
        Map<String, Boolean> map = new HashMap<>();
        map.put("valid", result);
        return map;
    }

    /**
     * 按照租住状态查找教师租房的房屋信息
     *
     * @param modelAndView
     * @param zzzt
     * @return
     */
    @Override
    public ModelAndView selectHouseByStatus(ModelAndView modelAndView, String zzzt) {
        House house = new House();
        house.setZzzt(zzzt);
        List<House> houseList = houseMapper.selectList(new EntityWrapper<>(house));
        if (!CollectionUtils.isEmpty(houseList)) {
            modelAndView.addObject("houseList", houseList);
            modelAndView.setViewName("house/houseList");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;

    }

    /**
     * 退房
     *
     * @param id
     * @return
     */
    @Override
    public String checkOutHouse(int id) {
        House house = houseMapper.selectById(id);
        house.setZzzt(HouseStatusEnum.CHECK_OUT_HOUSE.getStatus());
        //根据房间编号查找房间租住情况表中对应的信息
        HouseCzqk houseCzqk = new HouseCzqk();
        houseCzqk.setFjbh(house.getFjbh());
        HouseCzqk houseCzqk1 = houseCzqkMapper.selectOne(houseCzqk);
        houseCzqk1.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH_NOT_THROUGH.getStatus());
        houseCzqk1.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.TUI_FANG.getStatus());
        if (houseMapper.updateById(house) != 0) {
            if (houseCzqkMapper.updateById(houseCzqk1) != 0) {
                return "ok";
            }
        }
        return "error";
    }
}

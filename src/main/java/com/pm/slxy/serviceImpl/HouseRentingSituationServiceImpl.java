package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.Enum.TeacherRentalStatusEnum;
import com.pm.slxy.entity.HouseHistory;
import com.pm.slxy.entity.HousePub;
import com.pm.slxy.entity.HouseRentingSituation;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.HouseHistoryMapper;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.mapper.HouseRentingSituationMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseRentingSituationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.utils.JodaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-04-11
 */
@Service
public class HouseRentingSituationServiceImpl extends ServiceImpl<HouseRentingSituationMapper, HouseRentingSituation> implements HouseRentingSituationService {

    @Autowired
    private HouseRentingSituationMapper houseRentingSituationMapper;
    @Autowired
    private HousePubMapper housePubMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private HouseHistoryMapper houseHistoryMapper;

    /**
     * 添加房产租住信息并更新老师和房子的信息
     *
     * @param houseRentingSituation
     * @return
     */
    @Override
    public String rentalHouse(HouseRentingSituation houseRentingSituation) {
        if (StringUtils.isEmpty(houseRentingSituation.getApplycheckdate()) ||
                StringUtils.isEmpty(houseRentingSituation.getApplyexpiredate()) ||
                StringUtils.isEmpty(houseRentingSituation.getApplytime()) ||
                StringUtils.isEmpty(houseRentingSituation.getHouserentaltype()) ||
                StringUtils.isEmpty(houseRentingSituation.getRentallteachernumber()) ||
                StringUtils.isEmpty(houseRentingSituation.getRentalteacherdepartment()) ||
                StringUtils.isEmpty(houseRentingSituation.getRentalteachername()) ||
                StringUtils.isEmpty(houseRentingSituation.getWhetherdoubleone()) ||
                StringUtils.isEmpty(houseRentingSituation.getWhetherchild()) ||
                StringUtils.isEmpty(houseRentingSituation.getSpecialrentalhouse())) {
            return "输入的信息不能为空!";
        }
        HousePub housePub1 = new HousePub();
        housePub1.setHousenumber(houseRentingSituation.getHousenumber());
        HousePub housePub = housePubMapper.selectOne(housePub1);
        if (ObjectUtils.isEmpty(housePub)) {
            return "房间不存在";
        } else {
            housePub.setHousetype(houseRentingSituation.getHouserentaltype());
            housePub.setHousedepartment(houseRentingSituation.getRentalteacherdepartment());
            housePub.setHousestatus(HouseStatusEnum.ALREADY_RENTAL.getStatus());
            housePub.setHouseremarks(houseRentingSituation.getHouseremarks());
        }
        Teacher teacher1 = new Teacher();
        teacher1.setTeachernumber(houseRentingSituation.getRentallteachernumber());
        Teacher teacher = teacherMapper.selectOne(teacher1);
        if (ObjectUtils.isEmpty(teacher)) {
            return "教师不存在";
        } else {
            teacher.setTeacherhousingdate(houseRentingSituation.getApplycheckdate());
            teacher.setTeacherrentalstatus(TeacherRentalStatusEnum.ALREADY_RENTAL_HOUSE.getStatus());
        }
        if (housePubMapper.updateById(housePub) != 0 && teacherMapper.updateById(teacher) != 0) {
            if (this.insert(houseRentingSituation)) {
                return "ok";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }

    /**
     * 查询租房详情
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectHouseRentingHouse(ModelAndView modelAndView) {
        List<HouseRentingSituation> houseRentingHouseList = houseRentingSituationMapper.selectList(new EntityWrapper<HouseRentingSituation>());
        modelAndView.addObject("houseRentingHouseList", houseRentingHouseList);
        modelAndView.setViewName("/house/rentalHouseDetails");
        return modelAndView;
    }

    /**
     * 退房
     *
     * @param id
     * @return
     */
    @Override
    public String retreatHouse(int id) {
        HousePub housePub = housePubMapper.selectById(id);
        Teacher teacher = new Teacher();
        HouseRentingSituation houseRentingSituation1 = new HouseRentingSituation();
        if (!ObjectUtils.isEmpty(housePub)) {
            housePub.setHousetype("");
            housePub.setHousedepartment("");
            housePub.setHousestatus(HouseStatusEnum.NOT_RENTAL.getStatus());
            housePub.setHouseremarks("");

            houseRentingSituation1.setHousenumber(housePub.getHousenumber());
            houseRentingSituation1.setHousefloornumber(housePub.getHousefloornumber());
            HouseRentingSituation houseRentingSituation = houseRentingSituationMapper.selectOne(houseRentingSituation1);
            if (!ObjectUtils.isEmpty(houseRentingSituation)) {

                teacher.setTeachernumber(houseRentingSituation.getRentallteachernumber());
                Teacher teacher1 = teacherMapper.selectOne(teacher);

                if (!ObjectUtils.isEmpty(teacher1)) {
                    teacher1.setTeacherhousingdate("");
                    teacher1.setTeacherrentalstatus(TeacherRentalStatusEnum.NOT_RENTAL_HOUSE.getStatus());
                }

                HouseHistory houseHistory = new HouseHistory();
                houseHistory.setHousefloornumber(houseRentingSituation.getHousefloornumber());
                houseHistory.setApplycheckdate(houseRentingSituation.getApplycheckdate());
                houseHistory.setApplyexpiredate(houseRentingSituation.getApplyexpiredate());
                houseHistory.setApplyretreatdate(JodaTimeUtils.formatDateNow());
                houseHistory.setHousearea(houseRentingSituation.getHousearea());
                houseHistory.setHousenumber(houseRentingSituation.getHousenumber());
                houseHistory.setRentalteacherdepartment(houseRentingSituation.getRentalteacherdepartment());
                houseHistory.setWhetherchild(houseRentingSituation.getWhetherchild());
                houseHistory.setHouserentaltype(houseRentingSituation.getHouserentaltype());
                houseHistory.setRentalteachername(houseRentingSituation.getRentalteachername());

                if (housePubMapper.updateById(housePub) != 0 && teacherMapper.updateById(teacher1) != 0) {

                    if (houseHistoryMapper.insert(houseHistory) != 0) {

                        if (houseRentingSituationMapper.deleteById(houseRentingSituation.getId()) != 0) {
                            return "ok";
                        }
                        return "删除失败!";
                    }
                    return "插入历史数据失败!";
                }
                return "更新失败!";
            }
        }
        return "error";
    }
}

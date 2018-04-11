package com.pm.slxy.serviceImpl;

import com.pm.slxy.entity.HousePub;
import com.pm.slxy.entity.HouseRentingSituation;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.mapper.HouseRentingSituationMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseRentingSituationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

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
            if(ObjectUtils.isEmpty(housePub)) {
                return "房间不存在";
            } else {
                housePub.setHousetype(houseRentingSituation.getHouserentaltype());
                housePub.setHousedepartment(houseRentingSituation.getRentalteacherdepartment());
                housePub.setHousestatus("已被使用");
                housePub.setHouseremarks(houseRentingSituation.getHouseremarks());
            }
            Teacher teacher1 = new Teacher();
            teacher1.setTeachernumber(houseRentingSituation.getRentallteachernumber());
            Teacher teacher = teacherMapper.selectOne(teacher1);
            if (ObjectUtils.isEmpty(teacher)) {
                return "教师不存在";
            }
            else {
                teacher.setTeacherhousingdate(houseRentingSituation.getApplycheckdate());
                teacher.setTeacherrentalstatus("已租房");
            }
            if (housePubMapper.updateById(housePub) != 0 && teacherMapper.updateById(teacher) != 0) {
                if (this.insert(houseRentingSituation)) {
                    return "ok";
                } else  {
                    return "error";
                }
            } else {
                return "error";
            }
    }
}

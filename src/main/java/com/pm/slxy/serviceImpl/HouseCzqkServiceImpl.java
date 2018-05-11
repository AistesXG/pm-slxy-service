package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseApplyEnum;
import com.pm.slxy.Enum.HouseCzqkStatusEnum;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.House;
import com.pm.slxy.entity.HouseCzqk;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.HouseCzqkMapper;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.mapper.HousePubMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.HouseCzqkService;
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
 * @since 2018-05-06
 */
@Service
public class HouseCzqkServiceImpl extends ServiceImpl<HouseCzqkMapper, HouseCzqk> implements HouseCzqkService {

    @Autowired
    private HouseCzqkMapper houseCzqkMapper;
    @Autowired
    private HousePubMapper housePubMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private HouseMapper houseMapper;

    /**
     * 查找住房情况的详细列表
     *
     * @param modelAndView
     * @return
     */
    @Override
    public ModelAndView selectHouseCzqks(ModelAndView modelAndView) {
        List<HouseCzqk> houseCzqkList = houseCzqkMapper.selectList(new EntityWrapper<HouseCzqk>());
        modelAndView.setViewName("houseCzqk/houseCzqkList");
        modelAndView.addObject("houseCzqkList", houseCzqkList);
        return modelAndView;
    }

    /**
     * 根据id查找教师用房房屋信息渲染到HouseCzqk页面
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectHouseToCzqkById(ModelAndView modelAndView, int id) {
        House house = houseMapper.selectById(id);
        if (!ObjectUtils.isEmpty(house)) {
            modelAndView.addObject("house", house);
            modelAndView.addObject("departments", teacherMapper.selectDepartment());
            modelAndView.setViewName("houseCzqk/addHouseCzqk");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }


    @Override
    public String addHouseCzqk(HouseCzqk houseCzqk) {
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH_NOT_THROUGH.getStatus());
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        //将教师信息中的教师的参加工作时间添加到租住情况表中的教师参加工作时间
        houseCzqk.setJscjgzrq(teacher1.getCjgzrq());

        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setApply(HouseApplyEnum.APPLY_ENUM.getStatus());
//        //改变教师的申请住房日期和状态
//        Teacher teacher = new Teacher();
//        teacher.setXm(houseCzqk.getZzjsxm());
//        Teacher teacher1 = teacherMapper.selectOne(teacher);
//        teacher1.setSqzfrq(houseCzqk.getSqzzrq());
//        teacher1.setZfzt(HouseStatusEnum.ALREADY_RENTAL.getStatus());
//        //改变房屋的租住者所在部门和状态
//        House house = new House();
//        house.setFjbh(houseCzqk.getFjbh());
//        House house1 = houseMapper.selectOne(house);
//        house1.setZzzszbm(houseCzqk.getZzjsszbm());
//        house1.setZzzt(HouseStatusEnum.ALREADY_RENTAL.getStatus());
//        house1.setFjbz(houseCzqk.getBzsm());
//      if (teacherMapper.updateById(teacher1) != 0 && houseMapper.updateById(house1) != 0) {
        if (houseMapper.updateById(house1) != 0) {
            if (houseCzqkMapper.insert(houseCzqk) != 0) {
                return "ok";
            }
        }
//     }
        return "error";
    }

    /**
     * 根据id来查找房屋租住的情况
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectHouseCzqkById(ModelAndView modelAndView, int id) {
        HouseCzqk houseCzqk = houseCzqkMapper.selectById(id);
        if (!ObjectUtils.isEmpty(houseCzqk)) {
            modelAndView.addObject("houseCzqk", houseCzqk);
            modelAndView.setViewName("houseCzqk/HouseCzqkDetails");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 房屋审批通过
     *
     * @param id
     * @return
     */
    @Override
    public String applyThrough(int id) {
        HouseCzqk houseCzqk = houseCzqkMapper.selectById(id);
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
        //查找对应的房屋信息并修改字段
        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setZzzszbm(houseCzqk.getZzjsszbm());
        house1.setZzzt(HouseStatusEnum.ALREADY_RENTAL.getStatus());
        house1.setFjbz(houseCzqk.getBzsm());
        //查找对应的教师信息并修改字段
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        teacher1.setSqzfrq(houseCzqk.getSqzzrq());
        teacher1.setZfzt(HouseStatusEnum.ALREADY_RENTAL.getStatus());
        if (houseCzqkMapper.updateById(houseCzqk) != 0) {
            if (houseMapper.updateById(house1) != 0 && teacherMapper.updateById(teacher1) != 0) {
                return "ok";
            }
        }
        return "error";
    }

    /**
     * 根据fjbh来查找出来租房情况表中对应的房屋信息，然后进行续租
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectHouseCzqkReletById(ModelAndView modelAndView, int id) {
        House house = houseMapper.selectById(id);
        HouseCzqk houseCzqk1 = new HouseCzqk();
        houseCzqk1.setFjbh(house.getFjbh());
        HouseCzqk houseCzqk = houseCzqkMapper.selectOne(houseCzqk1);
        if (!ObjectUtils.isEmpty(houseCzqk)) {
            modelAndView.addObject("houseCzqk", houseCzqk);
            modelAndView.setViewName("/houseCzqk/reletHouse");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 续租房屋
     *
     * @param houseCzqk
     * @return
     */
    @Override
    public String reletHouse(HouseCzqk houseCzqk) {
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH_NOT_THROUGH.getStatus());
        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setZzzt(HouseStatusEnum.APPLY_RENTAL.getStatus());
        if (houseMapper.updateById(house1) != 0) {
            if (houseCzqkMapper.updateById(houseCzqk) != 0) {
                return "ok";
            }
        }
        return "error";
    }
}

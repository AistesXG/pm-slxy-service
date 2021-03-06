package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseApplyEnum;
import com.pm.slxy.Enum.HouseCzqkStatusEnum;
import com.pm.slxy.Enum.HouseCzqkZXTHouseStatusEnum;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.*;
import com.pm.slxy.mapper.*;
import com.pm.slxy.service.HouseCzqkService;
import com.pm.slxy.utils.JodaTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
    private TeacherMapper teacherMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private HouseHistoryMapper houseHistoryMapper;

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
        houseCzqk.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.ZU_FANG.getStatus());
        houseCzqk.setSfxz("否");
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        //将教师信息中的教师的参加工作时间添加到租住情况表中的教师参加工作时间
        houseCzqk.setJscjgzrq(teacher1.getCjgzrq());

        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setApply(HouseApplyEnum.APPLY_ENUM.getStatus());
        if (houseMapper.updateById(house1) != 0) {
            if (houseCzqkMapper.insert(houseCzqk) != 0) {
                return "ok";
            }
        }
        return "error";
    }

    /**
     * 教师申请租房的时候提交
     * @param houseCzqk
     * @return
     */
    @Override
    public String addTeacherHouseCzqk(HouseCzqk houseCzqk) {
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH_NOT_THROUGH.getStatus());
        houseCzqk.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.ZU_FANG.getStatus());
        houseCzqk.setSfxz("否");
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        //将教师信息中的教师的参加工作时间添加到租住情况表中的教师参加工作时间
        houseCzqk.setJscjgzrq(teacher1.getCjgzrq());
        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setApply(HouseApplyEnum.APPLY_ENUM.getStatus());
        if(teacher1.getZfzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus())  ) {
            return "您已经租房了!";
        }
        if(teacher1.getSfsq().equals("是")) {
            return "您已经申请过了!";
        }
        else {
            if (houseMapper.updateById(house1) != 0) {
                if (houseCzqkMapper.insert(houseCzqk) != 0) {
                    teacher1.setSfsq("是");
                    if(teacherMapper.updateById(teacher1) != 0) {
                        return "ok";
                    }
                }
            }
        }
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
     * 房屋租房和续租审批通过
     *
     * @param id
     * @return
     */
    @Override
    public String applyThrough(int id) {
        HouseCzqk houseCzqk = houseCzqkMapper.selectById(id);
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
        houseCzqk.setZfxztfzt("");
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
        houseCzqk1.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
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
     * 教师续租房屋
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectTeacherHouseCzqkReletById(ModelAndView modelAndView, int id) {
        House house = houseMapper.selectById(id);
        HouseCzqk houseCzqk1 = new HouseCzqk();
        houseCzqk1.setFjbh(house.getFjbh());
        houseCzqk1.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
        HouseCzqk houseCzqk = houseCzqkMapper.selectOne(houseCzqk1);
        if (!ObjectUtils.isEmpty(houseCzqk)) {
            modelAndView.addObject("houseCzqk", houseCzqk);
            modelAndView.setViewName("/houseCzqk/teacherReletHouse");
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
        houseCzqk.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.XUZU_FANG.getStatus());
        houseCzqk.setSfxz("是");
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

    /**
     * 教师续租房屋
     * @param houseCzqk
     * @param session
     * @return
     */
    @Override
    public String teacherReletHouse(HouseCzqk houseCzqk,HttpSession session) {
        Admin admin = (Admin)session.getAttribute("admins");
        String jggh = admin.getUser();
        if(houseCzqk.getZzjsbh().equals(jggh)) {
            houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH_NOT_THROUGH.getStatus());
            houseCzqk.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.XUZU_FANG.getStatus());
            houseCzqk.setSfxz("是");
            House house = new House();
            house.setFjbh(houseCzqk.getFjbh());
            House house1 = houseMapper.selectOne(house);
            house1.setZzzt(HouseStatusEnum.APPLY_RENTAL.getStatus());
            if (houseMapper.updateById(house1) != 0) {
                if (houseCzqkMapper.updateById(houseCzqk) != 0) {
                    return "ok";
                }
            }
        }else {
            return  "您不是这个房屋原始租住人，不能续租!";
        }
        return "error";
    }

    /**
     * 审批退房通过
     *
     * @param id
     * @return
     */
    @Override
    public String applyCheckOutHouse(int id) {
        HouseCzqk houseCzqk = houseCzqkMapper.selectById(id);
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_CHECK_OUT_HOUSE_THROUGH.getStatus());
        houseCzqk.setZfxztfzt("");
        //更新房屋信息列表的信息
        House house = new House();
        house.setFjbh(houseCzqk.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setZzzt(HouseStatusEnum.NOT_RENTAL.getStatus());
        house1.setZzzszbm("未选择");
        house1.setApply(HouseApplyEnum.NOT_APPLY_ENUM.getStatus());
        house1.setFjbz("");
        //更新教师列表中的信息
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        teacher1.setZfzt(HouseStatusEnum.NOT_RENTAL.getStatus());
        teacher1.setSqzfrq("0000-00-00");

        HouseHistory houseHistory = new HouseHistory();
        houseHistory.setFjbh(houseCzqk.getFjbh());  //房间编号
        houseHistory.setFjlh(houseCzqk.getFjlh());  //房间楼号
        houseHistory.setFjmj(houseCzqk.getFjmj()); // 房间面积
        houseHistory.setFjzzlx(houseCzqk.getFjzzlx()); //房间租住类型
        houseHistory.setSfcxqdxh(houseCzqk.getSfcxqdxh()); //是否带小孩
        houseHistory.setSqtzrq(JodaTimeUtils.formatDateNow()); //申请退房日期
        houseHistory.setSqzzrq(houseCzqk.getSqzzrq()); //申请租住日期
        houseHistory.setZzdqrq(houseCzqk.getZzdqrq()); //租住到期日期
        houseHistory.setZzjsbh(houseCzqk.getZzjsbh()); //教师编号
        houseHistory.setZzjsszbm(houseCzqk.getZzjsszbm()); //教师部门
        houseHistory.setZzjsxm(houseCzqk.getZzjsxm()); //教师姓名
        houseHistory.setSfxz(houseCzqk.getSfxz());  //是否续租

        if (houseHistoryMapper.insert(houseHistory) != 0) {
            if (houseMapper.updateById(house1) != 0 && teacherMapper.updateById(teacher1) != 0) {
                if (houseCzqkMapper.updateById(houseCzqk) != 0) {
                    return "ok";
                }
            }
        }
        return "error";
    }


    /**
     * 查找房屋信息到教师申请租房的页面
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectTeacherHouseToCzqkById(ModelAndView modelAndView, int id) {
        House house = houseMapper.selectById(id);
        if (!ObjectUtils.isEmpty(house)) {
            modelAndView.addObject("house", house);
            modelAndView.setViewName("houseCzqk/addTeacherHouseCzqk");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }
}

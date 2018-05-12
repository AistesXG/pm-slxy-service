package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseApplyEnum;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.House;
import com.pm.slxy.entity.HouseCzqk;
import com.pm.slxy.entity.NotApply;
import com.pm.slxy.entity.Teacher;
import com.pm.slxy.mapper.HouseCzqkMapper;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.mapper.NotApplyMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.service.NotApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-12
 */
@Service
public class NotApplyServiceImpl extends ServiceImpl<NotApplyMapper, NotApply> implements NotApplyService {

    @Autowired
    private HouseCzqkMapper houseCzqkMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private NotApplyMapper notApplyMapper;

    /**
     * 根据id来查找房屋租住情况表中的status
     *
     * @param id
     * @return
     */
    @Override
    public String selectStatusById(int id) {
        HouseCzqk houseCzqk = houseCzqkMapper.selectById(id);
        if (!ObjectUtils.isEmpty(houseCzqk)) {
            return JSON.toJSONString(houseCzqk);
        }
        return "error";
    }

    /**
     * 审批未通过
     *
     * @param notApply
     * @return
     */
    @Override
    public String addNotApply(NotApply notApply) {
        //查找租房情况表更新对应的字段
        HouseCzqk houseCzqk = new HouseCzqk();
        houseCzqk.setZfxztfzt(notApply.getStatus());
        HouseCzqk houseCzqk1 = houseCzqkMapper.selectOne(houseCzqk);
        houseCzqk1.setZfxztfzt("");
        //查找教师用房表更新对应的字段
        House house = new House();
        house.setFjbh(houseCzqk1.getFjbh());
        House house1 = houseMapper.selectOne(house);
        house1.setZzzszbm("未选择");
        house1.setZzzt(HouseStatusEnum.NOT_RENTAL.getStatus());
        house1.setApply(HouseApplyEnum.NOT_APPLY_ENUM.getStatus());
        house1.setFjbz("");
        //查找教师表更新对应的字段
        Teacher teacher = new Teacher();
        teacher.setJggh(houseCzqk1.getZzjsbh());
        Teacher teacher1 = teacherMapper.selectOne(teacher);
        teacher1.setSqzfrq("0000-00-00");
        teacher1.setZfzt(HouseStatusEnum.NOT_RENTAL.getStatus());

        if (teacherMapper.updateById(teacher1) != 0 && houseMapper.updateById(house1) != 0 && houseCzqkMapper.updateById(houseCzqk1) != 0) {
            if (notApplyMapper.insert(notApply) != 0) {
                return "ok";
            }
        }
        return "error";
    }
}

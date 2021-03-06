package com.pm.slxy.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.Enum.HouseApplyEnum;
import com.pm.slxy.Enum.HouseCzqkStatusEnum;
import com.pm.slxy.Enum.HouseCzqkZXTHouseStatusEnum;
import com.pm.slxy.Enum.HouseStatusEnum;
import com.pm.slxy.entity.*;
import com.pm.slxy.mapper.HouseCzqkMapper;
import com.pm.slxy.mapper.HouseMapper;
import com.pm.slxy.mapper.TeacherMapper;
import com.pm.slxy.mapper.ZjhsbzMapper;
import com.pm.slxy.service.HouseService;
import com.pm.slxy.utils.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    @Autowired
    private ZjhsbzMapper zjhsbzMapper;

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
        for (House house : houseList) {
            if (house.getZzzt().equals(HouseStatusEnum.ALREADY_RENTAL.getStatus()) || houseList.get(0).getZzzt().equals(HouseStatusEnum.APPLY_RENTAL.getStatus()) || houseList.get(0).getZzzt().equals(HouseStatusEnum.CHECK_OUT_HOUSE.getStatus())) {
                return "您删除的房子已经租出去了,申请退房或者被续租了";
            }
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
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
        HouseCzqk houseCzqk1 = houseCzqkMapper.selectOne(houseCzqk);
        houseCzqk1.setSpzt(HouseCzqkStatusEnum.APPROVAL_CHECK_OUT_HOUSE_NOT_THROUGH.getStatus());
        houseCzqk1.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.TUI_FANG.getStatus());
        if (houseMapper.updateById(house) != 0) {
            if (houseCzqkMapper.updateById(houseCzqk1) != 0) {
                return "ok";
            }
        }
        return "error";
    }

    /**
     * 教师退房
     * @param id
     * @param session
     * @return
     */
    @Override
    public String teacherCheckOutHouse(int id, HttpSession session) {
        Admin admin = (Admin)session.getAttribute("admins");
        String jggh = admin.getUser();
        House house = houseMapper.selectById(id);
        house.setZzzt(HouseStatusEnum.CHECK_OUT_HOUSE.getStatus());
        //根据房间编号查找房间租住情况表中对应的信息
        HouseCzqk houseCzqk = new HouseCzqk();
        houseCzqk.setFjbh(house.getFjbh());
        houseCzqk.setSpzt(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus());
        HouseCzqk houseCzqk1 = houseCzqkMapper.selectOne(houseCzqk);
        houseCzqk1.setSpzt(HouseCzqkStatusEnum.APPROVAL_CHECK_OUT_HOUSE_NOT_THROUGH.getStatus());
        houseCzqk1.setZfxztfzt(HouseCzqkZXTHouseStatusEnum.TUI_FANG.getStatus());
        if(houseCzqk1.getZzjsbh().equals(jggh)) {
            if (houseMapper.updateById(house) != 0) {
                if (houseCzqkMapper.updateById(houseCzqk1) != 0) {
                    return "ok";
                }
            }
        }
        return "您不是本房间租住人，不能申请退房!";
    }

    /**
     * 计算费用
     *
     * @param modelAndView
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public ModelAndView Calculation(ModelAndView modelAndView, String startTime, String endTime) throws Exception {
            List<Calculation> calculations = getCalculations(startTime, endTime);
        if (!CollectionUtils.isEmpty(calculations)) {
            for(int i=0;i<calculations.size();i++){
                modelAndView.addObject("sum",calculations.get(calculations.size()-1).getSum());
            }
            modelAndView.addObject("calculations", calculations);
            modelAndView.setViewName("calculationPrice/CalculationPrice");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

    /**
     * 获取费用数据
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws ParseException
     */
    private List<Calculation> getCalculations(String startTime, String endTime) throws ParseException {
        List<HouseCzqk> houseCzqks = houseCzqkMapper.selectList(new EntityWrapper<HouseCzqk>());
        List<Zjhsbz> prices = zjhsbzMapper.selectList(new EntityWrapper<Zjhsbz>());
        List<Calculation> calculations = new ArrayList<>();
        float sum = 0;
        for (HouseCzqk houseCzqk : houseCzqks) {
            if (houseCzqk.getSpzt().equals(HouseCzqkStatusEnum.APPROVAL_THROUGH.getStatus())) {
                Calculation calculation = new Calculation();
                calculation.setFjlh(houseCzqk.getFjlh()); //房间楼号
                calculation.setFjbh(houseCzqk.getFjbh()); //房间编号
                calculation.setSfqr(houseCzqk.getSqzzrq()); //申请日期
                calculation.setDqrq(houseCzqk.getZzdqrq());//到期日期
                calculation.setZzlx(houseCzqk.getFjzzlx());//租住类型
                calculation.setFjmj(houseCzqk.getFjmj());//房间面积
                for (Zjhsbz zjhsbz : prices) { //原始租金标准
                    switch (calculation.getZzlx()) {
                        case "保障期单间":
                            calculation.setZjbz(zjhsbz.getBzqdj());
                            break;
                        case "保障期单元房":
                            calculation.setZjbz(zjhsbz.getBzqdyf());
                            break;
                        case "延长期单间":
                            calculation.setZjbz(zjhsbz.getYcqdj());
                            break;
                        case "延长期单元房":
                            calculation.setZjbz(zjhsbz.getYcqdyf());
                            break;
                        case "超限期单间":
                            calculation.setZjbz(zjhsbz.getCxqdj());
                            break;
                        case "超限期单元房":
                            calculation.setZjbz(zjhsbz.getCxqdyf());
                            break;
                        default:
                            break;
                    }
                }
                calculation.setSfszg(houseCzqk.getSfszg());//是否双职工
                calculation.setJsxs(houseCzqk.getTszzxs());//计算系数
                calculation.setSzbm(houseCzqk.getZzjsszbm());//所在部门
                calculation.setJsxm(houseCzqk.getZzjsxm());//教师姓名
                calculation.setYzf(calculation.getFjmj() * calculation.getZjbz() * calculation.getJsxs());//月租费
                //格式化日期
                SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat endDate = new SimpleDateFormat("yyyy-MM-dd");
                Date startDateS = startDate.parse(startTime);
                Date endDateS = endDate.parse(endTime);
                //计算毫秒数
                long startDateSeconds = startDateS.getTime();
                long endDateSeconds = endDateS.getTime();
                //得到两者之差
                long startAndEndSeconds = endDateSeconds - startDateSeconds;
                //毫秒转为秒
                int totalSeconds = (int) (startAndEndSeconds / 1000);
                //得到总天数
                int days = totalSeconds / (3600 * 24);
                int month = 0;
                //判断月数
                if (days < 30.5 && days > 1) {
                    month = (int) (days / 30.5) + 1;
                } else if (days >= 30.5) {
                    if (days % 30.5 < 1) {
                        month = (int) (days / 30.5);
                    } else {
                        month = (int) (days / 30.5) + 1;
                    }
                }
                calculation.setMonth(month);
                calculation.setJdzj(calculation.getMonth() * calculation.getYzf()); //季度租金
                calculation.setGzrq(houseCzqk.getJscjgzrq()); //工作日期
                calculation.setSfcxqdxh(houseCzqk.getSfcxqdxh());//带小孩
                calculation.setTszs(houseCzqk.getTszzxs());//特殊系数
                sum += calculation.getJdzj();
                calculation.setSum(sum);
                calculations.add(calculation);
            }
        }
        return calculations;
    }

    /**
     * 导出费用表
     *
     * @param startTime
     * @param endTime
     * @return
     * @throws InvocationTargetException
     * @throws ClassNotFoundException
     * @throws IntrospectionException
     * @throws ParseException
     * @throws IllegalAccessException
     */
    @Override
    public XSSFWorkbook exportPriceToExcel(String startTime, String endTime) throws InvocationTargetException, ClassNotFoundException, IntrospectionException, ParseException, IllegalAccessException {
        List<Calculation> calculations = getCalculations(startTime, endTime);
        List<ExcelBean> excel = new ArrayList<>();
        Map<Integer, List<ExcelBean>> map = new LinkedHashMap<>();
        XSSFWorkbook xssfWorkbook = null;
        //设置标题栏
        excel.add(new ExcelBean("房间楼号", "fjlh", 0));
        excel.add(new ExcelBean("房间编号", "fjbh", 0));
        excel.add(new ExcelBean("申请日期", "sfqr", 0));
        excel.add(new ExcelBean("到期日期", "dqrq", 0));
        excel.add(new ExcelBean("租住类型", "zzlx", 0));
        excel.add(new ExcelBean("房间面积", "fjmj", 0));
        excel.add(new ExcelBean("原始租金标准", "zjbz", 0));
        excel.add(new ExcelBean("是否双职工", "sfszg", 0));
        excel.add(new ExcelBean("计算系数", "jsxs", 0));
        excel.add(new ExcelBean("所在部门", "szbm", 0));
        excel.add(new ExcelBean("教师姓名", "jsxm", 0));
        excel.add(new ExcelBean("月租费", "yzf", 0));
        excel.add(new ExcelBean("月数", "month", 0));
        excel.add(new ExcelBean("季度租金", "jdzj", 0));
        excel.add(new ExcelBean("工作日期", "gzrq", 0));
        excel.add(new ExcelBean("是否带小孩", "sfcxqdxh", 0));
        excel.add(new ExcelBean("特殊系数", "tszs", 0));
        map.put(0, excel);
        String sheetName = "calculationPrice";
        //调用ExcelUtil的方法
        xssfWorkbook = ExcelUtil.createExcelFile(Calculation.class, calculations, map, sheetName);
        return xssfWorkbook;

    }


}

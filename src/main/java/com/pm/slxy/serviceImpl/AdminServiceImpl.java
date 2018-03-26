package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.Admin;
import com.pm.slxy.mapper.AdminMapper;
import com.pm.slxy.service.AdminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
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
 * @since 2018-03-20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    /**
     * 登录
     *
     * @param user
     * @param pass
     * @return
     */
    @Override
    public List<Admin> login(String user, String pass) {
        if (user != null && pass != null) {
            Admin admin = new Admin();
            admin.setUser(user);
            admin.setPass(pass);
            List<Admin> admins = adminMapper.selectList(new EntityWrapper<>(admin));
            if (!CollectionUtils.isEmpty(admins)) {
                if (admins.size() == 1) {
                    return admins;
                }
            }
        }
        return null;
    }

    /**
     * 查询所有用户
     *
     * @return
     */
    @Override
    public ModelAndView selectAdmins(ModelAndView modelAndView) {
        List<Admin> adminList = adminMapper.selectList(new EntityWrapper<Admin>());
        modelAndView.addObject("adminList", adminList);
        modelAndView.setViewName("admin/AdminDetails");
        return modelAndView;
    }


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public String deleteAdminByIds(String ids) {
        //将字符串转为字符串list集合
        List<String> adminIds = Arrays.asList(ids.split(","));
        int delete = adminMapper.deleteBatchIds(adminIds);
        if (delete != 0) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    @Override
    public String addAdmin(Admin admin) {
        if (StringUtils.isEmpty(admin.getUser())) {
            return "用户名不能为空！";
        }
        if (StringUtils.isEmpty(admin.getPass())) {
            return "密码不能为空";
        }
        if (StringUtils.isEmpty(admin.getEmail())) {
            return "邮箱不能为空";
        }
        if (StringUtils.isEmpty(admin.getPhone())) {
            return "电话号码不能为空";
        }
        Admin user = new Admin();
        user.setUser(admin.getUser());
        Admin admin1 = this.selectOne(new EntityWrapper<>(user));
        if (!ObjectUtils.isEmpty(admin1)) {
            return "用户名已经存在";
        }
        if (this.insert(admin)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 检测用户名
     *
     * @param user
     * @return
     */
    @Override
    public String checkUser(String user) {
        if (StringUtils.isEmpty(user)) {
            return "error";
        }
        Admin admin = new Admin();
        admin.setUser(user);
        List<Admin> admins = this.selectList(new EntityWrapper<>(admin));
        if (CollectionUtils.isEmpty(admins)) {
            return "ok";
        } else {
            return "error";
        }
    }


    /**
     * 更新用户信息
     *
     * @param admin
     * @return
     */
    @Override
    public String updateAdmin(Admin admin) {
        if (this.updateById(admin)) {
            return "ok";
        } else {
            return "error";
        }
    }

    /**
     * 查找一个用户
     *
     * @param modelAndView
     * @param id
     * @return
     */
    @Override
    public ModelAndView selectAdmin(ModelAndView modelAndView, int id) {
        Admin admin = adminMapper.selectById(id);
        if (!ObjectUtils.isEmpty(admin)) {
            modelAndView.addObject("admin", admin);
            modelAndView.setViewName("admin/updateAdmin");
        } else {
            modelAndView.setViewName("404");
        }
        return modelAndView;
    }

}

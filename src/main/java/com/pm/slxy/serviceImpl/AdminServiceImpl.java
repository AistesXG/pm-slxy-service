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

import java.util.ArrayList;
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
    public List<Admin> selectAdmins() {
        List<Admin> admins = adminMapper.selectList(new EntityWrapper<Admin>());
        if (!CollectionUtils.isEmpty(admins)) {
            return admins;
        }
        return null;
    }


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @Override
    public int deleteAdminByIds(String ids) {
        //将字符串转为字符串list集合
        List<String> adminIds = Arrays.asList(ids.split(","));
        int delete = adminMapper.deleteBatchIds(adminIds);
        if (delete != 0) {
            return delete;
        }
        return 0;
    }

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    @Override
    public int addAdmin(Admin admin) {
        if (!ObjectUtils.isEmpty(admin)) {
            int add = adminMapper.insert(admin);
            if (add != 0) {
                return add;
            }
        }
        return 0;
    }

    /**
     * 检测用户名
     *
     * @param user
     * @return
     */
    @Override
    public boolean checkUser(String user) {
        if (StringUtils.isEmpty(user)){
            return  false;
        }
        boolean checkUser = adminMapper.checkUser(user);
        if (checkUser) {
            return true;
        }
        return false;
    }


}

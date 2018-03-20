package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.pm.slxy.entity.Admin;
import com.pm.slxy.mapper.AdminMapper;
import com.pm.slxy.service.AdminService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
            if(!CollectionUtils.isEmpty(admins)) {
                if(admins.size() == 1) {
                     return admins;
                }
            }
        }
        return null;
    }
}

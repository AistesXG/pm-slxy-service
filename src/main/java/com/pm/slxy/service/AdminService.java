package com.pm.slxy.service;

import com.pm.slxy.entity.Admin;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚
 * @since 2018-03-20
 */
public interface AdminService extends IService<Admin> {
    /**
     * 登录
     *
     * @param user
     * @param pass
     * @return
     */
    List<Admin> login(String user, String pass);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<Admin> selectAdmins();


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    int deleteAdminByIds(String ids);

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    int addAdmin(Admin admin);

    /**
     * 检测用户名
     *
     * @param user
     * @return
     */
    boolean checkUser(String user);


}

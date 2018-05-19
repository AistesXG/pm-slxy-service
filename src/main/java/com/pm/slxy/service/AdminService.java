package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.Admin;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

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
    ModelAndView selectAdmins(ModelAndView modelAndView);


    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    String deleteAdminByIds(String ids);

    /**
     * 添加用户
     *
     * @param admin
     * @return
     */
    String addAdmin(Admin admin);

    /**
     * 检测用户名
     *
     * @param user
     * @return
     */
    Map<String, Boolean> checkUser(String user);

    /**
     * 修改密码是检测用户名是否存在
     * @param user
     * @return
     */
    Map<String,Boolean> checkUserSFCZ(String user);

    /**
     * 修改用户信息
     *
     * @param admin
     * @return
     */
    String updateAdmin(Admin admin);

    /**
     * 查找一个用户
     *
     * @param modelAndView
     * @return
     */
    ModelAndView selectAdmin(ModelAndView modelAndView, int id);

    /**
     * 修改密码
     * @param user
     * @param pass
     * @return
     */
    String updatePass(String user,String pass);
}

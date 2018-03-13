package com.pm.slxy.service;

import com.baomidou.mybatisplus.service.IService;
import com.pm.slxy.entity.User;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-03-01
 */
public interface UserService extends IService<User> {

    /**
     * 用户登录
     *
     * @param userName
     * @param userPassword
     * @return
     */
    List<User> Login(String userName, String userPassword);


}

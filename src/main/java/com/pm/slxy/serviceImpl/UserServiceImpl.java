package com.pm.slxy.serviceImpl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.pm.slxy.entity.User;
import com.pm.slxy.mapper.UserMapper;
import com.pm.slxy.service.UserService;
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
 * @since 2018-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 用户登录
     *
     * @param userName
     * @param userPassword
     * @return
     */
    @Override
    public List<User> Login(String userName, String userPassword) {
        if (userName != null && userPassword != null) {
            User user = new User();
            user.setUserName(userName);
            user.setUserPassword(userPassword);
            List<User> users = userMapper.selectList(new EntityWrapper<>(user));
            if (!CollectionUtils.isEmpty(users)) {
                return users;
            }
        }
        return null;
    }

}

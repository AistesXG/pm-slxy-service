package com.pm.slxy.utils;

import com.pm.slxy.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;

/**
 * controller注解
 * @author furg@senthink.com
 * @date 2018/4/4
 */
public class AuthoritySys extends HandlerInterceptorAdapter {


    private static final Logger LOGGER = LoggerFactory.getLogger(AuthoritySys.class);

    @Override
    public boolean preHandle(HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod)
        {
            SysControllerFilter sysControllerFilter = ((HandlerMethod) handler).getMethodAnnotation(SysControllerFilter.class);

            //controller有添加SysControllerFilter注解
            if (sysControllerFilter != null)
            {
                Admin admin = (Admin) request.getSession().getAttribute("admins");
                if (admin != null) {
                    return true;
                }
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
        return true;
    }
}

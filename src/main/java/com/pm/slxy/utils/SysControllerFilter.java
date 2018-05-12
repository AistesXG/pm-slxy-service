package com.pm.slxy.utils;

import java.lang.annotation.*;

/**
 * @author furg@senthink.com
 * @date 2018/4/4
 */
@Documented
@Target(
        {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SysControllerFilter {
    String name();
}

package com.pm.slxy.controller;


import com.pm.slxy.entity.Admin;
import com.pm.slxy.service.AdminService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.NamedBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 付荣刚
 * @since 2018-03-20
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 查询用户列表
     *
     * @param modelAndView
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/adminList")
    @SysControllerFilter(name = "adminList")
    public ModelAndView selectAdmins(ModelAndView modelAndView) throws Exception {
        return adminService.selectAdmins(modelAndView);
    }


    /**
     * 批量删除+单个删除
     *
     * @param ids
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/deleteAdminByIds")
    @SysControllerFilter(name= "deleteAdminByIds")
    @ResponseBody
    public String deleteAdminByIds(String ids) throws Exception {
        return adminService.deleteAdminByIds(ids);
    }

    /**
     * 添加用户
     *
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/addAdmin")
    @SysControllerFilter(name = "/addAdmin")
    @ResponseBody
    public String addAdmin(Admin admin) throws Exception {
        return adminService.addAdmin(admin);
    }


    /**
     * 更新用户信息
     *
     * @param admin
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/updateAdmin")
    @SysControllerFilter(name = "/updateAdmin")
    @ResponseBody
    public String updateAdmin(Admin admin) throws Exception {
        return adminService.updateAdmin(admin);
    }

    /**
     * 查找一个用户
     *
     * @param modelAndView
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/selectAdmin")
    @SysControllerFilter(name = "selectAdmin")
    public ModelAndView selectAdmin(ModelAndView modelAndView, String id) throws Exception {
        return adminService.selectAdmin(modelAndView, Integer.parseInt(id));
    }
}


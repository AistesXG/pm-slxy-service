package com.pm.slxy.controller;


import com.pm.slxy.entity.NotApply;
import com.pm.slxy.service.HouseCzqkService;
import com.pm.slxy.service.NotApplyService;
import com.pm.slxy.utils.SysControllerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 付荣刚123
 * @since 2018-05-12
 */
@Controller
@RequestMapping("/notApply")
public class NotApplyController {

    @Autowired
    private NotApplyService notApplyService;

    @RequestMapping(value = "/selectStatusById")
    @SysControllerFilter(name = "selectStatusById")
    @ResponseBody
    public String selectStatusById(String id) throws Exception {
        return notApplyService.selectStatusById(Integer.parseInt(id));
    }

    @RequestMapping(value = "/addNotApply")
    @SysControllerFilter(name = "addNotApply")
    @ResponseBody
    public String addNotApply(NotApply notApply) throws Exception {
        return notApplyService.addNotApply(notApply);
    }
}


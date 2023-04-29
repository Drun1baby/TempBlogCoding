package com.star.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.entity.User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserCRDUController {

    

    @Autowired
    private UserService userService;

    //    分页查询用户列表
    @GetMapping("/admin/userManage")
    public String manageView(){
        //按照排序字段 倒序 排序
        return "admin/test";
    }
}

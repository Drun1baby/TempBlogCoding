package com.star.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.star.entity.User;
import com.star.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

//用户管理
@Controller
@RequestMapping("/admin")
public class UserPageController {
    @Autowired
    private UserService userService;

    //    分页查询用户列表
    @GetMapping("/userManage")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        //按照排序字段 倒序 排序
        String orderBy = "id desc";
        PageHelper.startPage(pageNum,10,orderBy);
        List<User> list = userService.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        model.addAttribute("pageInfo",pageInfo);
        return "admin/userManage";
    }

    //    返回新增用户页面
    @GetMapping("/userManage/input")
    public String input(Model model){
        model.addAttribute("user", new User());
        return "admin/user-input";
    }

    //  新增用户
    @PostMapping("/userManage")
    public String post(@Valid User user, RedirectAttributes attributes) {
        User user1 = userService.getUserByName(user.getUsername());
        if (user1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的用户");
            return "redirect:/admin/userManage/input";
        }
        int t = userService.saveUser(user);
        if (t == 0) {
            attributes.addFlashAttribute("message", "新增失败");
        } else {
            attributes.addFlashAttribute("message", "新增成功");
        }
        return "redirect:/admin/userManage";
    }

    //    跳转修改分类页面
    @GetMapping("/userManage/{id}/input")
    public String editInput(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "admin/userManage-input";
    }

    //    编辑修改用户
    @PostMapping("/userManage/{id}")
    public String editPost(@Valid User user, RedirectAttributes attributes) {
        User user1 = userService.getUserByName(user.getUsername());
        if (user1 != null) {
            attributes.addFlashAttribute("message", "不能添加重复的分类");
            return "redirect:/admin/userManage/input";
        }
        int t = userService.updateUser(user);
        if (t == 0 ) {
            attributes.addFlashAttribute("message", "编辑失败");
        } else {
            attributes.addFlashAttribute("message", "编辑成功");
        }
        return "redirect:/admin/userManage";
    }

    //    删除分类
    @GetMapping("/userManage/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        userService.deleteUser(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/userManage";
    }
}

package com.Tmall.controller;

import com.Tmall.bean.User;
import com.Tmall.service.UserService;
import com.Tmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author jingyi
 * @Classname UserController
 * @description TODO
 * @date 2021/8/3 10:33
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("admin_user_list")
    public String getUserlist(Page page, Model model) {
        int total = userService.total();
        page.setTotal(total);
        List<User> userlist = userService.list(page);
        model.addAttribute("userlist", userlist);
        return "admin/listUser";
    }
    @RequestMapping("admin_user_edit")
    public String toUpdateUserPwd(Model model,Integer id) {
        User user = userService.getUserByid(id);
        model.addAttribute("u", user);
        return "admin/editUser";
    }
    @RequestMapping("admin_user_update")
    public String upDateUserPwd(User u) {
        userService.updateUserPwd(u);
        return "redirect:admin_user_list";
    }
    @RequestMapping("admin_user_delete")
    public String deleteUserById(Integer id) {
        userService.deleteUserByid(id);
        return "redirect:admin_user_list";
    }

}

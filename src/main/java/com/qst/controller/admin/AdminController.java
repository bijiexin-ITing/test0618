package com.qst.controller.admin;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.Auser;
import com.qst.service.admin.AdminService;
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;
    @RequestMapping("/admin")
    public String toLogin(@ModelAttribute Auser auser) {
        return "admin/login";
    }
    @RequestMapping("/admin/login")
    public String login(@ModelAttribute Auser auser, Model model, HttpSession session) {
        return adminService.login(auser, model, session);
    }
    @RequestMapping("/exit")
    public String exit(@ModelAttribute Auser auser,HttpSession session) {
        session.invalidate();
        return "admin/login";
    }
    @RequestMapping("/admin/toAddUser")
    public String toAdd( Model model, HttpSession session) {
        //展示后台用户名单
        adminService.queryAuser(model, session);
        return "admin/toAddUser";
    }
    
    @RequestMapping("/admin/addUser")
    public String addUser(Auser user, Model model, HttpSession session) {
        //展示后台用户名单
        adminService.addUser(user);
        adminService.queryAuser(model, session);
        return "admin/toAddUser";
    }
    @RequestMapping("/admin/deleteUser")
    public String deleteUser(Auser user, Model model, HttpSession session) {
        //展示后台用户名单
        adminService.deleteUser(user);
        adminService.queryAuser(model, session);
        return "admin/toAddUser";
    }
    @RequestMapping("/admin/updateUser")
    public String updateUser(Auser user,Model model,HttpSession session){
    	adminService.updateUser(user);
    	adminService.queryAuser(model, session);
    	return "admin/toAddUser";
    }
}

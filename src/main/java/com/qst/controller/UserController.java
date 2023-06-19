package com.qst.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.Buser;
import com.qst.entity.Goods;
import com.qst.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 注册页
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model,HttpSession session, Goods goods) {
        return "register";
    }
    /**
     * 登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model,HttpSession session, Goods goods) {
        return "login";
    }
    
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String register(Buser buser,Model model, HttpSession session/*, String code*/) {
        return userService.register(buser, model, session, null);
    }
    @RequestMapping("/login")
    public String login(Buser buser,Model model, HttpSession session/*, String code*/) {
        return userService.login(buser, model, session, null);
    }
    @RequestMapping("/logOut")
    public String exit(HttpSession session) {
        session.invalidate();
        return "forward:/index";
    }
}
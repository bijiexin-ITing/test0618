package com.qst.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.qst.dao.UserDao;
import com.qst.entity.Buser;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Override
    public String register(Buser buser, Model model, HttpSession session, String code) {
        //目前不考虑验证码
        if(code!=null && !code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("codeError", "验证码错误！");
            return "register";
        }
        int n = userDao.register(buser);
        if(n > 0) {
            return "login";
        }else {
            model.addAttribute("msg", "注册失败！");
            return "register";
        }
    }
    @Override
    public String login(Buser buser, Model model, HttpSession session, String code) {
        //目前不考虑验证码
        if(code!=null && !code.equalsIgnoreCase(session.getAttribute("code").toString())) {
            model.addAttribute("msg", "验证码错误！");
            return "login";
        }
        Buser ruser = null;
        List<Buser> list = userDao.login(buser);
        if(list.size() > 0) {
            ruser = list.get(0);
        }
        if(ruser != null) {
            session.setAttribute("bruser", ruser);
            return "shoppingIndex";
        }else {
            model.addAttribute("msg", "邮箱或密码错误！");
            return "login";
        }
    }

}
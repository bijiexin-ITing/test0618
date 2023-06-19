package com.qst.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.qst.exception.UserLoginNoException;
@Controller
public class BaseBeforeController {
	
	@ModelAttribute  
    public void isLogin(HttpSession session, HttpServletRequest request) throws UserLoginNoException {      
       if(session.getAttribute("bruser") == null){  
            throw new UserLoginNoException("你还未登录!");
       }  
    } 
}

package com.qst.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.qst.entity.Auser;

public interface AdminService {
    public String login(Auser auser, Model model, HttpSession session);
    public String queryAuser( Model model, HttpSession session);
    public String addUser( Auser auser);
    public String updateUser(Auser auser);
    public String deleteUser( Auser auser);
}
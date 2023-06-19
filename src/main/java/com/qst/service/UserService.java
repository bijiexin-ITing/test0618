package com.qst.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.qst.entity.Buser;

public interface UserService {
	public String register(Buser buser,Model model, HttpSession session, String code);
	public String login(Buser buser,Model model, HttpSession session, String code);
}

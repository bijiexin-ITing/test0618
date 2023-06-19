package com.qst.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface UserCenterService {
	public String userCenter(HttpSession session, Model model);
}

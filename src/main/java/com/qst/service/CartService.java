package com.qst.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface CartService {
	public String selectCart(Model model, HttpSession session);
}

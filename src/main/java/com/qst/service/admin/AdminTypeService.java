package com.qst.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public interface AdminTypeService {
	public String toAddType(Model model);
	public String toAddType2(Model model);
	public String addType(String typename,Model model,HttpSession session);
	public String addType2(int parentid,String typename,Model model,HttpSession session);
	public String toDeleteType(Model model);
	public String deleteType(Integer id,Model model);
}

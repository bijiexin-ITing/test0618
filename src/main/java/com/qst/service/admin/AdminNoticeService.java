package com.qst.service.admin;

import org.springframework.ui.Model;

import com.qst.entity.Notice;

public interface AdminNoticeService {
	public String addNotice(Notice notice);
	public String deleteNoticeSelect(Model model);
	public String selectANotice(Model model, Integer id);
	public String deleteNotice(Integer id);
}

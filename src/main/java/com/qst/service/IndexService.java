package com.qst.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.qst.entity.Goods;

public interface IndexService {
    public String index(Model model,HttpSession session, Goods goods);
    public String toRegister(Model model);
    public String toLogin(Model model);
    public String goodsDetail(Model model,Integer id);
    public String selectANotice(Model model,Integer id);
    public String search(Model model,String mykey);
    public String shoppingShow(Model model, HttpSession session, int goodTypeId);
}
package com.qst.service;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
public interface OrderService {
    public String buyGoods(Model model, HttpSession session,HashMap<Integer, Integer> order);
    public String pay(Integer ordersn);
    public String toShoppingOrder(Model model, HttpSession session);
}
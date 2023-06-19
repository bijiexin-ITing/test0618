package com.qst.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qst.entity.Goods;
import com.qst.service.IndexService;
@Controller
public class IndexController {
    @Autowired
    private IndexService indexService;
    /**
     * 首页
     */
    @RequestMapping("/index")
    public String before(Model model,HttpSession session, Goods goods) {
        return indexService.index(model, session, goods);
    }
    /**
     * 商品列表
     */
    @RequestMapping("/shoppingShow")
    public String shoppingShow(Model model,HttpSession session,int goodTypeId) {
        return indexService.shoppingShow(model, session, goodTypeId);
    }
    /**
     * 转到注册页面
     */
    @RequestMapping("/toRegister")
    public String toRegister(Model model) {
        return indexService.toRegister(model);
    }
    /**
     * 转到登录页面
     */
    @RequestMapping("/toLogin")
    public String toLogin(Model model) {
        return indexService.toLogin(model);
    }
    
    /**
     * 转到商品详情页
     */
    @RequestMapping("/goodsDetail")
    public String goodsDetail(Model model,Integer id) {
        return indexService.goodsDetail(model, id);
    }
    
    /**
     * 转到公告页面
     */
    @RequestMapping("/selectANotice")
    public String selectANotice(Model model,Integer id) {
        return indexService.selectANotice(model, id);
    }
    /**
     * 首页搜索
     */
    @RequestMapping("/search")
    public String search(Model model,String mykey) {
        return indexService.search(model, mykey);
    }
}
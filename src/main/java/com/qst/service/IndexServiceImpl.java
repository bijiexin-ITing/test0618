package com.qst.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.qst.dao.AdminNoticeDao;
import com.qst.dao.AdminTypeDao;
import com.qst.dao.IndexDao;
import com.qst.entity.Buser;
import com.qst.entity.Goods;
import com.qst.entity.Notice;

@Service("indexService")
@Transactional
public class IndexServiceImpl implements IndexService{
    @Autowired
    private IndexDao indexDao;
    @Autowired
    private AdminTypeDao adminTypeDao;
    @Autowired
    private AdminNoticeDao adminNoticeDao;
    @Override
    public String index(Model model, HttpSession session, Goods goods) {
        session.setAttribute("goodsType", adminTypeDao.selectGoodsType());
        model.addAttribute("salelist", indexDao.getSaleOrder());
        model.addAttribute("focuslist", indexDao.getFocusOrder());
        model.addAttribute("noticelist", indexDao.selectNotice());
        if(goods.getId() == null) 
            goods.setId(0);
        model.addAttribute("lastedlist", indexDao.getLastedGoods(goods));
        return "shoppingIndex";
    }
    @Override
    public String shoppingShow(Model model, HttpSession session, int goodTypeId) {
        model.addAttribute("goodlist", adminTypeDao.selectGoodsByType(goodTypeId));
        model.addAttribute("goodType",adminTypeDao.selectGoodType(goodTypeId));
        return "shoppingShow";
    }

    @Override
    public String toRegister(Model model) {
        model.addAttribute("rbuser", new Buser());
        return "register";
    }

    @Override
    public String toLogin(Model model) {
        model.addAttribute("lbuser", new Buser());
        return "login";
    }

    @Override
    public String goodsDetail(Model model, Integer id) {
        Goods goods = indexDao.selectGoodsById(id);
        model.addAttribute("goods", goods);
        return "before/goodsdetail";
    }

    @Override
    public String selectANotice(Model model, Integer id) {
        Notice notice = adminNoticeDao.selectANotice(id);
        model.addAttribute("notice", notice);
        return "admin/noticeDetail";
    }

    @Override
    public String search(Model model, String mykey) {
        List<Goods> list = indexDao.search(mykey);
        model.addAttribute("searchlist", list);
        return "before/searchResult";
    }


    
}


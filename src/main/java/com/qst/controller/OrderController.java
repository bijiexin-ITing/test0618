package com.qst.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qst.entity.Buser;
import com.qst.entity.Order;
import com.qst.service.OrderService;

// import net.sf.json.JSONObject;

@Controller
@RequestMapping("/order")
public class OrderController extends BaseBeforeController{
    @Autowired
    private OrderService orderService;
    /**
     * 提交订单
     */
    @RequestMapping("/buyGoods")
    @ResponseBody
    public String buyGoods(Model model, HttpSession session,@RequestBody String orderJson) {
        //json要导入好几个包
        /*JSONObject jsonObject = JSONObject.fromObject(orderJson);
        Map<Object, Object> orderMap = (Map)jsonObject;*/
        HashMap<Integer, Integer> orderMap =new HashMap<Integer, Integer>();
        String[] tt = orderJson.replaceAll("\"", "").replace("{", "").replace("}", "").split(",");
        for(int i=0;i<tt.length;i++) {
            int goodid = Integer.parseInt(tt[i].split(":")[0]);
            int goodnum = Integer.parseInt(tt[i].split(":")[1]);
            orderMap.put(goodid, goodnum);
        }
        return orderService.buyGoods(model, session, orderMap);
    }
    /**
     * 转到订单详情页
     */
    @RequestMapping("/toShoppingOrder")
    public String toShoppingOrder(Model model, HttpSession session) {
        return orderService.toShoppingOrder(model, session);
    }
    
    /**
     * 支付订单
     */
    @RequestMapping("/pay")
    public String pay(Integer ordersn) {
        return orderService.pay(ordersn);
    }
}
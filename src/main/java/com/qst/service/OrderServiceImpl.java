package com.qst.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.qst.dao.OrderDao;
import com.qst.entity.Buser;
import com.qst.entity.Order;
import com.qst.util.MyUtil;
@Service("orderService")
@Transactional
/**
 * 订单生成有连串的更新操作，此处必须使用事务管理
 */
public class OrderServiceImpl implements OrderService{
    @Autowired
    private OrderDao orderDao;
    /**
     * 订单提交，连续的事务处理
     */
    @Override
    public String buyGoods(Model model, HttpSession session, HashMap<Integer, Integer> goodNum) {
        Order order = new Order();
        order.setBusertable_id(MyUtil.getUserId(session));
        order.setAmount(new Double(0));
        //生成订单，并将主键返回order
        orderDao.addOrder(order);
        //生成订单详情
        Map<String, Object> map = new HashMap<String, Object>();

        for (int key : goodNum.keySet()) {
            int goodId = key;
            int num = (int) goodNum.get(key);
            map.put("orderId", order.getId());
            map.put("goodId", goodId);
            map.put("goodNum", num);
            orderDao.addOrderDetail(map);
            //订单金额
            orderDao.updateOrderAmount(map);
            //更新库存
            orderDao.updateStore(map);
        }
        return "order/toShoppingOrder";
    }
    @Override
    public String pay(Integer ordersn) {
        orderDao.pay(ordersn);
        return "before/paydone";
    }
    @Override
    public String toShoppingOrder(Model model, HttpSession session) {
        List<Order> orderList = orderDao.selectOrderByUser(MyUtil.getUserId(session));
        model.addAttribute("orderList",orderList);
        return "shoppingOrder";
    }

}
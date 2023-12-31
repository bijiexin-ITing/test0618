package com.qst.entity;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author louise
 * @date 2019.4.26
 */
public class Order  implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer busertable_id;
    private Double amount;
    private Integer status;
    private String orderdate;
    private List<OrderDetail> orderDetails;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getBusertable_id() {
        return busertable_id;
    }
    public void setBusertable_id(Integer busertable_id) {
        this.busertable_id = busertable_id;
    }
    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getOrderdate() {
        return orderdate;
    }
    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }
    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
    
}
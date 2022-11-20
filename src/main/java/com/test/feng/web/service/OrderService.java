package com.test.feng.web.service;

import com.test.feng.web.dao.OrderDao;
import com.test.feng.web.entity.Cart;
import com.test.feng.web.entity.Order;
import com.test.feng.web.entity.OrderList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;
    //查看訂單所有內容
    public List<Order> getAllOrder(){
        return dao.findAll();
    }
    //新增購物車總額至訂單
    @Transactional
    public Order addToOrder(Order order){
        dao.addToOrder(order.getMem_ID());
        return order;
    }
    //Join購物車查詢
    public List<Map<String,Object>> getAllDetail(OrderList orderList) {
       return dao.getAllList(orderList.getMem_ID());
    }



}

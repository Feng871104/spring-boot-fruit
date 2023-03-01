package com.test.feng.web.service.impl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.OrderDaoRepository;
import com.test.feng.web.entity.Order;
import com.test.feng.web.entity.OrderList;
import com.test.feng.web.service.OrderService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDaoRepository dao;
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
        log.info("訂單內容:");
        for (Map<String,Object> m : dao.getAllList(orderList.getMem_ID())) {
            log.info("商品名稱:"+m.get("f_Name") + ","+ "購買數量:" + m.get("f_Amount"));
        }
        log.info("總金額:"+dao.getAllList(orderList.getMem_ID()).get(0).get("o_Total")+"元");
        return dao.getAllList(orderList.getMem_ID());
    }



}

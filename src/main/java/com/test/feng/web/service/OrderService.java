package com.test.feng.web.service;

import com.test.feng.web.dao.OrderDao;
import com.test.feng.web.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderDao dao;

    public List<Order> getAllOrder(){
        return dao.findAll();
    }
}

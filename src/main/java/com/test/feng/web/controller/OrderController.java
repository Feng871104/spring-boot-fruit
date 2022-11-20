package com.test.feng.web.controller;

import com.test.feng.web.entity.Order;
import com.test.feng.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService checkOutService;

    @GetMapping("/getAllOrder")
    public List<Order> getAll(){
        return checkOutService.getAllOrder();
    }
}

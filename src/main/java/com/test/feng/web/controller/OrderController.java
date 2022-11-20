package com.test.feng.web.controller;

import com.test.feng.web.entity.Cart;
import com.test.feng.web.entity.Order;
import com.test.feng.web.entity.OrderList;
import com.test.feng.web.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    //查看訂單ID與總金額
    @GetMapping("/getAllOrder")
    public List<Order> getAll(){
        return orderService.getAllOrder();
    }
    //新增訂單ID和總金額
    @PostMapping(value = "/addToOrder")
    public String addToOrder(@RequestBody Order order){
        orderService.addToOrder(order);
        return "成功";
    }
    //列出水果與總金額
    @PostMapping(value = "/getAllDetail")
    public List<Map<String,Object>> getAllDetail(@RequestBody OrderList orderList){
        return orderService.getAllDetail(orderList);
    }
}

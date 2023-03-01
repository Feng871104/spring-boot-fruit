package com.test.feng.web.service;

import java.util.List;
import java.util.Map;

import com.test.feng.web.entity.Order;
import com.test.feng.web.entity.OrderList;

public interface OrderService {
	
	public List<Order> getAllOrder();
	
	public Order addToOrder(Order order);
	
	public List<Map<String,Object>> getAllDetail(OrderList orderList);

}

package com.test.feng.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.feng.web.entity.Cart;
import com.test.feng.web.entity.Fruit;
import com.test.feng.web.service.CartService;
import com.test.feng.web.service.FruitService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	@Autowired
	private FruitService fruitService;

	// 檢查並新增
	@PostMapping(value = "/checkAdd")
	public Cart add(@RequestBody Cart cart) {
		cartService.addfruit(cart);
		return cart;
	}
	// 取得購物車全部的資料
	@GetMapping(value = "/allCart")
	public List<Cart> get() {
		return cartService.getAll();
	}
	// 刪除購物車指定資料
	@DeleteMapping(value = "/deletFruit")
	public String deleteFruit(@RequestParam Integer detail_ID) {
		cartService.deleteFruit(detail_ID);
		return "刪除成功";
	}
	// 測試檢查是否有效
	@PostMapping(value = "/testCheck")
	public boolean checkfruit(@RequestBody Fruit fruit) {
		return fruitService.checkadd(fruit.getF_Name());
	}
	@PostMapping(value = "/testCart")
	public boolean testcart(@RequestBody Cart cart) {
		return cartService.checkCart(cart.getF_Name());
	}

}

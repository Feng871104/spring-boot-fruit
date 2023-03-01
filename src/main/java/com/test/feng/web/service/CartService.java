package com.test.feng.web.service;

import java.util.List;

import com.test.feng.web.entity.Cart;

public interface CartService {
	
	 public Cart addfruit(Cart cart);
	 
	 public List<Cart> getAll();
	 
	 public Cart incdec(Cart cart);
	 
	 public void deleteFruit(Integer id);
	 
	 public boolean checkCart(String fruitName);

}

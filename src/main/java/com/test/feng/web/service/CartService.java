package com.test.feng.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.CartDao;
import com.test.feng.web.entity.Cart;

import lombok.extern.slf4j.Slf4j;
/**
 * @author a0932
 *
 * @since 2022/11/19 下午 09:46
 **/
@Slf4j
@Service
public class CartService {

	@Autowired
	private CartDao dao;
	
	@Autowired
	private FruitService fruitService;
	
	public Cart addfruit(Cart cart) {
		if (fruitService.checkadd(cart.getF_Name())) {
			log.info("沒有這個水果");
			return cart;
		} else if (!checkCart(cart.getF_Name())) {
			log.info("購物車已存在此水果");
			return cart;
		}
		log.info("新增成功");
		dao.saveAndFlush(cart);
		return cart;
	}

	public List<Cart> getAll() {
		return dao.findAll();

	}
	public void deleteFruit(Integer ID) {
		dao.deleteById(ID);
	}
	public boolean checkCart(String f_Name) {
		return dao.cartCheck(f_Name).isEmpty();
	}

}

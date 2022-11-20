package com.test.feng.web.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.CartDao;
import com.test.feng.web.entity.Cart;

import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;

/**
 * @author a0932
 *
 * @since 2022/11/21 上午 02:38
 **/
@Slf4j
@Service
public class CartService {

	@Autowired
	private CartDao dao;
	
	@Autowired
	private FruitService fruitService;

	//檢查商品並新增
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
	//取得所有購物車資料
	public List<Cart> getAll() {
		return dao.findAll();
	}
	//購物車資料數量調整
	@Transactional
	public Cart incdec(Cart cart){
		dao.incdec(cart.getF_Amount(),cart.getF_Name());
		return cart;
	}
	//刪除購物車指定ID所有資料
	public void deleteFruit(Integer ID) {
		dao.deleteById(ID);
	}
	//檢查購物車商品重複
	public boolean checkCart(String f_Name) {
		return dao.cartCheck(f_Name).isEmpty();
	}

}

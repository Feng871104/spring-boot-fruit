package com.test.feng.web.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.CartDaoRepository;
import com.test.feng.web.entity.Cart;
import com.test.feng.web.service.CartService;
import com.test.feng.web.service.FruitService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author a0932
 * @since 2022/11/21 上午 02:38
 **/
@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDaoRepository dao;

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
        } else if (cart.getF_Amount() > fruitService.findAmount(cart.getF_Name()).get(0).getF_Amount() || cart.getF_Amount() <= 0 ) {
            log.info("請勿空白且數量不能為0，可輸入最大數量為:" + fruitService.findAmount(cart.getF_Name()).get(0).getF_Amount());
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
    public Cart incdec(Cart cart) {
        dao.incdec(cart.getF_Amount(), cart.getF_Name());
        return cart;
    }

    //刪除購物車指定ID所有資料
    public void deleteFruit(Integer id) {
        dao.deleteById(id);
    }

    //檢查購物車商品重複
    public boolean checkCart(String fruitName) {
        return dao.cartCheck(fruitName).isEmpty();
    }

}

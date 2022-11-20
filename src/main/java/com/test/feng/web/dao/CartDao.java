package com.test.feng.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.feng.web.entity.Cart;
/**
 * @author a0932
 *
 * @since 2022/11/21 上午 02:41
 **/
@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	//檢查加入的購物車商品重複
	@Query(value = "select * from f_cart where f_Name = ?1", nativeQuery = true)
	List<Cart> cartCheck(String f_name);

	//購物車商品數量調整
	@Modifying
	@Query(value = "update f_cart set f_Amount=f_Amount+(?1) where f_Name=?2",nativeQuery = true)
	void  incdec(Integer f_Amount,String f_Name);
}

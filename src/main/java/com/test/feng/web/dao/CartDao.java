package com.test.feng.web.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.feng.web.entity.Cart;

@Repository
public interface CartDao extends JpaRepository<Cart, Integer> {
	@Query(value = "select * from f_detail where f_Name = ?1", nativeQuery = true)
	List<Cart> cartCheck(String f_name);
}

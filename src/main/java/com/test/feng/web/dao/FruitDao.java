package com.test.feng.web.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.feng.web.entity.Fruit;

@Repository
public interface FruitDao extends JpaRepository<Fruit, Integer>{
	//檢查水果存在
	@Query(value = "select * from f_info where f_Name = ?1", nativeQuery = true)
	List<Fruit> checkName(String f_Name);



}

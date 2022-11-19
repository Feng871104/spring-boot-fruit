package com.test.feng.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.FruitDao;
import com.test.feng.web.entity.Fruit;

@Service
public class FruitService {
	
	@Autowired
	private FruitDao dao;
	
	public boolean checkadd(String f_Name) {
		return dao.checkName(f_Name).isEmpty();
		
	}
	public List<Fruit> getAll(){
		return dao.findAll();
	}
}

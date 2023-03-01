package com.test.feng.web.service;

import java.util.List;

import com.test.feng.web.entity.Fruit;

public interface FruitService {
	
	public boolean checkadd(String fName);
	
	public List<Fruit> getAll();
	
	public List<Fruit> findAmount(String fName);
}

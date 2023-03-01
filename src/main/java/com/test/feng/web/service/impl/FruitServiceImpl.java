package com.test.feng.web.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.feng.web.dao.FruitDaoRepository;
import com.test.feng.web.entity.Fruit;
import com.test.feng.web.service.FruitService;

@Service
public class FruitServiceImpl implements FruitService {

    @Autowired
    private FruitDaoRepository dao;

    //檢查存在的水果
    public boolean checkadd(String fName) {
        return dao.checkName(fName).isEmpty();
    }

    //查看全部水果
    public List<Fruit> getAll() {
        return dao.findAll();
    }

    //查出水果數量
	public List<Fruit> findAmount(String fName){
		System.out.println(dao.checkName(fName).get(0).getF_Amount());
    	return dao.checkName(fName);
	}


}

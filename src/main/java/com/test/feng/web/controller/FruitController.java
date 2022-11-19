package com.test.feng.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.feng.web.entity.Fruit;
import com.test.feng.web.service.FruitService;

@RestController
@RequestMapping("/fruit")
public class FruitController {
	@Autowired
	private FruitService fruitService;
	
	@GetMapping(value = "/getAll")
	public List<Fruit> getAllFruit(){
		return fruitService.getAll();
	}

}

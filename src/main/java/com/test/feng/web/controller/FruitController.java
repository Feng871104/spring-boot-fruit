package com.test.feng.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.feng.web.entity.Fruit;
import com.test.feng.web.service.FruitService;

@RestController
@RequestMapping("/fruit")
public class FruitController {
	@Autowired
	private FruitService fruitService;
	//查詢所有水果資料
	@GetMapping(value = "/getAll")
	public List<Fruit> getAllFruit(){
		return fruitService.getAll();
	}
	@PostMapping(value = "/findAmount")
	public List<Fruit> findAmount(@RequestBody Fruit fruit){
		return fruitService.findAmount(fruit.getF_Name());
	}



}

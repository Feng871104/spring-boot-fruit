package com.test.feng.web.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "f_info")
public class Fruit {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer f_ID;
	private String f_Name;
	private Integer f_Price;
	private Integer f_Amount;
}

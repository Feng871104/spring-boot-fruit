package com.test.feng.web.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderList {
    @Id
    private Integer mem_ID;
    private String f_Name;
    private Integer f_Amount;
    private Integer o_Total;
}

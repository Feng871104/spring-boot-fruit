package com.test.feng.web.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.test.feng.web.entity.Order;

public interface OrderDaoRepository extends JpaRepository<Order,Integer> {
    //將購物車總金額寫入訂單
    @Modifying
    @Query(value = "insert into f_order(mem_ID,o_Total) value(?1,(select sum(f_price*f_Amount) from f_cart where mem_ID=?1 ))",nativeQuery = true)
    void addToOrder(Integer mem_ID);
    //查詢join購物車內容
    @Query(value = "select a.f_Name,a.f_Amount,b.o_Total from f_cart a join f_order b on(a.mem_ID=b.mem_ID) where a.mem_ID=?1",nativeQuery = true)
    List<Map<String,Object>> getAllList(Integer mem_ID);

}

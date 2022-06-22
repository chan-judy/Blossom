package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dto.OrdersVO;
import com.spring.boot.mapper.OrdersMapper;
 
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/orders")
public class OrdersController {
 
    @Autowired
    OrdersMapper ordersMapper;
    
    @GetMapping("/list")
    public List<OrdersVO> ordersList(){
        System.out.println(ordersMapper.ordersList());
        return ordersMapper.ordersList();
    }

   
    @PostMapping
    void insertOrders(@RequestBody OrdersVO orders) {
    	ordersMapper.insertOrders(orders);
        System.out.println("유저 DB 저장 성공");
    }
    
    @DeleteMapping("/list/{p_num}")
    public void deleteAllcart(@PathVariable int p_num) {
    	ordersMapper.deleteAllcart(p_num);
    }
    
    @GetMapping("/{o_num}")
    public OrdersVO fetchOrdersByID(@PathVariable int o_num) {
        System.out.println(ordersMapper.fetchOrdersByID(o_num));
        OrdersVO fetchOrders = ordersMapper.fetchOrdersByID(o_num);
        return fetchOrders;
    }

}
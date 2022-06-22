package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.CartVO;
import com.spring.boot.dto.OrdersVO;
 
 
@Mapper
public interface OrdersMapper {
 
    public List <OrdersVO> ordersList();
    OrdersVO fetchOrdersByID(int  o_num);
    void insertOrders(OrdersVO orders);
    void deleteAllcart(int  p_num);
    
    
    
}
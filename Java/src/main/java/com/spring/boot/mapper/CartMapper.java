package com.spring.boot.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.boot.dto.CartVO;
 
 
@Mapper
public interface CartMapper {
 
    public List<CartVO> cartList();
    CartVO fetchcartByID(int  p_num);
    void updatecart(CartVO cart);
    void deletecart(int  p_num);
    public int sumCount();
    public int sumTotal();
}
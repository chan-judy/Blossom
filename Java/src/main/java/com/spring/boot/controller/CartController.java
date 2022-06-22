package com.spring.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.dto.CartVO;
import com.spring.boot.mapper.CartMapper;
 
 
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cart")
public class CartController {
 
    @Autowired
    CartMapper cartMapper;
    
    @GetMapping("/list")
    public List<CartVO> cartList(){
        System.out.println(cartMapper.cartList());
        return cartMapper.cartList();
    }
    
    @GetMapping("/{p_num}")
    public CartVO fetchcartByID(@PathVariable int  p_num) {
        System.out.println(cartMapper.fetchcartByID( p_num));
        CartVO fetchcart = cartMapper.fetchcartByID(p_num);
        return fetchcart;
    }
        
    @PutMapping("/list/{p_num}")
    public void updatecart(@PathVariable int p_num, @RequestBody CartVO cart) {
        CartVO updatecart = cart;
        System.out.println(updatecart);
        updatecart.setC_quantity(cart.getC_quantity());
        cartMapper.updatecart(updatecart); 
    }
    
    @DeleteMapping("/list/{p_num}")
    public void deletecart(@PathVariable int p_num) {
        cartMapper.deletecart(p_num);
    }
    
  @GetMapping("/sumCount")
    public int sumCount() {
     return cartMapper.sumCount();
    }

    
  @GetMapping("/sumTotal")
  public int sumTotal() {
   return cartMapper.sumTotal();
  }

    
    
}
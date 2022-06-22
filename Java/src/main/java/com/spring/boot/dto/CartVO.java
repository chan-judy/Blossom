package com.spring.boot.dto;
 
import lombok.Data;
 
@Data
public class CartVO {
 
    private int p_num;
    private String p_size;
    private int c_quantity;
    private String b_store;
    private String p_name;
    private  String p_photo;
    private int p_oriprice;
    private int p_price;
    private int sumCount;
    private int sumTotal;
 
    
}

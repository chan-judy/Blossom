package com.spring.boot.dto;
 
import lombok.Data;
 
@Data
public class OrdersVO {
 
    int o_num;
    String m_id;
    String o_addr1;
    String o_addr2;
    String o_addr3;
    int o_tel;
    String o_date;
    String o_memo;
    String o_state;
    String o_paytype;
    String o_name;
    int o_point;
    int c_num;
    int c_dis;
    int o_total;
    int o_price;
}

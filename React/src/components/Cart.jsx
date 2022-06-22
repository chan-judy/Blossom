import React, { useCallback, useEffect, useState } from 'react';
import styles from '../asset/css/Cart.module.css';
import sample from './sample.jpg';
import axios from 'axios';

const Cart = (cart) =>{

    const [list, setList] = useState([{}])
    let num = 1

    useEffect(() =>
    {
        axios.get("http://localhost:8080/cart/list")
        .then(res => {
            setList(res.data)
        })
    }, [])



    /*---------수량 변경---------*/

    // const [input, SetInput] = useState('');

    // const updatecart = p_num => {
    //     SetInput(input)
    //     list.map(cart => {
    //     axios.put("http://localhost:8080/cart/list/"+ cart.p_num, cart)
    //     .then( res => {
    //         setList(list.map(cart => cart.p_num === p_num ? { ...cart, input : !cart.c_quantity } : cart)
    //         );

    //         console.log('된다!');
    // })
    // .catch((error) => {
    //     console.error('안된다');
    // })
    
    // })}


    /*---------목록에서 삭제---------*/
    const deletecart = useCallback((p_num) => {
        axios.delete("http://localhost:8080/cart/list/"+p_num)
        .then(res=>{
            setList(list => {return list.filter(cart => cart.p_num !== p_num);
        })
        }, []);
    });


    return (

        <div className={styles.container1}>
            <div className={styles.cartcart}>
                <ul>
                    <li><b>장바구니({})</b></li>
                    <li><b>장바구니 &#62;</b> 주문결제 &#62; 주문완료</li>
                </ul>
            </div>
            <table className={styles.tr1}>
                <thead>
                    <tr>
                        <th colSpan='3'>상품명</th>
                        <th>정가</th>
                        <th>판매가</th>
                        <th>수량</th>
                        <th>합계</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                {
                list.map(cart =>
                    <tr key={`LKEY${num++}`}>
                       <td>
                        {/* <input type='checkbox' id='checkbox1'/> 
                        <label for='checkbox1'/> */}
                        </td>
                        <td><img src={sample}/></td> 
                        <td>
                            <b>[{cart.b_store}]</b><br/>{cart.p_name}<br/>{cart.p_size}
                        </td>
                        <td>{cart.p_oriprice}원</td>
                        <td>{cart.p_price}원</td>
                        <td>{cart.c_quantity}개</td>
                        <td>{cart.c_quantity*cart.p_price}원</td>
                        <td><button onClick={() => deletecart(cart.p_num)}>Χ</button></td>
                    </tr>
                )}
                </tbody>
                </table>
                <hr/>

                <p className={styles.c_total}><span>총 수량 : {}개 </span> / <span>총 금액 : {}원</span></p>

                <hr/>
                <button className={styles.orderbutton} >결제하기</button> 
            </div>
    );
    }
export default Cart;
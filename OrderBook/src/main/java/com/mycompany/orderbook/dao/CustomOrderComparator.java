/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.dao;

import com.mycompany.orderbook.dto.Order;
import java.util.Comparator;

/**
 *
 * @author bobur
 */
public class CustomOrderComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        
        
        
        return o1.getPrice().compareTo(o2.getPrice());
    }

}

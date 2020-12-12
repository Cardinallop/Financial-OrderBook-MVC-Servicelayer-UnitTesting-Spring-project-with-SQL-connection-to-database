/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.dto;

import java.util.UUID;

/**
 *
 * @author bobur
 */
public class practice {
    
    public static void main(String[] args) {
        
        String uniqueID = UUID.randomUUID().toString();
		int uniqueIDd = (int)(1+Math.random()*9);
		 
                 
                 System.out.println("BORD-"+ uniqueID);
    }
    
}

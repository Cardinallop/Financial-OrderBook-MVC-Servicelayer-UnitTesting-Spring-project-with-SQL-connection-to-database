/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author bobur
 */
public class Order {
    
    private String orderID;
	private BigDecimal price;
	private int quantity;
	
public String getOrderID() {
		
	return this.orderID;
	}

    public void setOrderId(String orderID) {
        this.orderID = orderID;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
	
	public BigDecimal getPrice() {
		
		return this.price;
	}
	
	public int getQuantity() {
	return this.quantity;
	}

    public void setQuantity(int i) {
        quantity = i;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", price=" + price + ", quantity=" + quantity + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.orderID);
        hash = 97 * hash + Objects.hashCode(this.price);
        hash = 97 * hash + this.quantity;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (this.quantity != other.quantity) {
            return false;
        }
        if (!Objects.equals(this.orderID, other.orderID)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
	
    
	
	
    
    
}

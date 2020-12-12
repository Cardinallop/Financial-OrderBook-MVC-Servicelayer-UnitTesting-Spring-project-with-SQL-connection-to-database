/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 *
 * @author bobur
 */
public class Trade {
    
        private String uniqueiid;
	
	private LocalDateTime executionTime;
	
	private int quantity;
	
	private BigDecimal executionPrice;

    public String getUniqueiid() {
        return uniqueiid;
    }

    public void setUniqueiid(String uniqueiid) {
        this.uniqueiid = uniqueiid;
    }

    public LocalDateTime getLdt() {
        return executionTime;
    }

    public void setLdt(LocalDateTime ldt) {
        this.executionTime = ldt;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getExecutionPrice() {
        return executionPrice;
    }

    public void setExecutionPrice(BigDecimal executionPrice) {
        this.executionPrice = executionPrice;
    }

    public void setTradeID(String string) {
        
        uniqueiid = string;
    }

    public void setExecutionTime(LocalDateTime ld) {
        executionTime = ld;
    }

    public void setPrice(BigDecimal price) {
        executionPrice = price;
    }

    public LocalDateTime getExecutionTime() {
        return executionTime;
    }

    @Override
    public String toString() {
        return "Trade{" + "uniqueiid=" + uniqueiid + ", executionTime=" + executionTime + ", quantity=" + quantity + ", executionPrice=" + executionPrice + '}';
    }
    
    
        
        
    
}

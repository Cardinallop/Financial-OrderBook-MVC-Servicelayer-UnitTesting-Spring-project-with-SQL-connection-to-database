/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.service;

import com.mycompany.orderbook.dto.Order;
import com.mycompany.orderbook.dto.Trade;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.mycompany.orderbook.dao.OrderBookDao;

/**
 *
 * @author bobur
 */
public class DaostubIMPL implements OrderBookDao {
    
    private Order onlyOrder;
    
    public DaostubIMPL(){
        
        onlyOrder = new Order();
        onlyOrder.setOrderId("1");
        onlyOrder.setPrice(new BigDecimal("190.57"));
        onlyOrder.setQuantity(34);
        
        
    }
    
    public DaostubIMPL(Order order){
        this.onlyOrder = order;
    }

    public void GenerateOrderBook() {
      //do nothing...
    }

    @Override
    public List<Order> GetBuyOrders() {
        List<Order> BUYorderlist = new ArrayList<>();
        BUYorderlist.add(onlyOrder);
        return BUYorderlist;
        
    }

    @Override
    public List<Order> GetSellOrders() {
        List<Order> SELLorderlist = new ArrayList<>();
        SELLorderlist.add(onlyOrder);
        return SELLorderlist;
    }

    @Override
    public Boolean addTrade(Trade trade) {
        return true;
        
    }

    @Override
    public Trade MatchOrders() {
        return null;
       
    }

    @Override
    public String MatchAllOrders() {
        return null;
        //do nothing
    }

    @Override
    public List<Object> OrderBookStats() {
        return null;
        
    }

    @Override
    public Trade GetTradeByID(String ID) {
        return null;
       
    }

    @Override
    public List<Trade> TradesByExecutionTime() {
        return null;
       
    }

    @Override
    public Order addBuyOrder(Order buyOrder) {
        return null;
        
    }

    @Override
    public Order addSellOrder(Order buyOrder) {
        return null;
        
    }

    @Override
    public Order editOrder(List<String> orderInfo, String buyOrSell) {
        return null;
        
    }
    
}

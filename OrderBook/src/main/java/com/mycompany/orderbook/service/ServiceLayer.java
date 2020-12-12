/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.service;

import com.mycompany.orderbook.dao.OrderDaoException;
import com.mycompany.orderbook.dto.Order;
import com.mycompany.orderbook.dto.Trade;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bobur
 */
public interface ServiceLayer {
       public List<Order> GetBuyOrders();

    public List<Order> GetSellOrders();

    public Boolean addTrade(Trade trade);

    public Trade MatchOrders();

    public String MatchAllOrders();

    public List<Object> OrderBookStats();

    public Trade GetTradeByID(String ID);

    public List<Trade> TradesByExecutionTime();

//    Order editOrder(List<String> orderInfo, String buyOrSell);
//
//    Order addSellOrder(Order sellOrder);
//
//    Order addBuyOrder(Order buyOrder);
  
    void addBuyOrder(Order buyOrder) throws DuplicateIDexception, DataValidationException, OrderDaoException, IOException;

    void addSellOrder(Order buyOrder) throws DuplicateIDexception, DataValidationException, OrderDaoException, IOException;

    Order editOrder(List<String> orderInfo, String buyOrSell) throws DataValidationException, DuplicateIDexception;
  
}

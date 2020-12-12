/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.dao;

import com.mycompany.orderbook.dto.Order;
import com.mycompany.orderbook.dto.Trade;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author bobur
 */
public interface OrderBookDao {
    List<Order> GetBuyOrders();
    List<Order> GetSellOrders();
    Boolean addTrade(Trade trade);
    Trade MatchOrders();
    String MatchAllOrders();
    List<Object> OrderBookStats();
    Trade GetTradeByID(String ID);
    List<Trade> TradesByExecutionTime();
    Order addBuyOrder(Order buyOrder) throws OrderDaoException, IOException;
    Order addSellOrder(Order sellOrder) throws OrderDaoException, IOException;
    Order editOrder(List<String> orderInfo, String buyOrSell);
}

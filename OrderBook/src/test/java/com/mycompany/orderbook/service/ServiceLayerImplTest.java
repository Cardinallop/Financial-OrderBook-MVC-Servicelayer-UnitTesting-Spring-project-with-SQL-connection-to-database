/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.service;

import com.mycompany.orderbook.dto.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.mycompany.orderbook.dao.OrderBookDao;
import com.mycompany.orderbook.dao.OrderDaoException;
import java.io.IOException;

/**
 *
 * @author bobur
 */
public class ServiceLayerImplTest {
    
    /**  
     *    We test for three possible cases of business rules:
     * 
     *    1. Adding a buy order with invalid inputs cannot work
     *    2. Adding a sell order with invalid inputs cannot work
     *    3. Editing an order with invalid inputs cannot work
     * 
     */
         ServiceLayer serv;
    
    public ServiceLayerImplTest() {
        
        OrderBookDao daotest = new DaostubIMPL();
        
        serv = new ServiceLayerImpl(daotest);
    }
    
    
    @Test
    public void testAddBuyOrder() throws OrderDaoException, IOException {
        
        //Arrange
        Order buyOrder = new Order();
        buyOrder.setOrderId("0");
        buyOrder.setPrice(new BigDecimal(190));
        buyOrder.setQuantity(27);
        
        //Act
        try{
            serv.addBuyOrder(buyOrder);
        }catch(DataValidationException | DuplicateIDexception
                | OrderDaoException | IOException e){
            
        //Assert
            fail("Buy order was valid. No exception should have been thrown");
        }
       
    }
    
    @Test
    public void testAddSellOrder() throws OrderDaoException, IOException {
        
        //Arrange
        Order sellOrder = new Order();
        sellOrder.setOrderId("1");
        sellOrder.setPrice(new BigDecimal(190.45));
        sellOrder.setQuantity(35);
        
        //Act
        try{
            serv.addSellOrder(sellOrder);
        }catch(DataValidationException | DuplicateIDexception | OrderDaoException | IOException e){
            
        //Assert
            fail("Sell order was valid. No exception should have been thrown");
        }
       
    }
    
        public void testEditOrder() {
        
        //Arrange

        List<String> orderInforma = new ArrayList<>();
        orderInforma.add("2");
        orderInforma.add("190.33");
        orderInforma.add("44");
        
        String buysell = "B";
        
        //Act
        try{
            serv.editOrder(orderInforma, buysell);
        }catch(DataValidationException | DuplicateIDexception e){
            
        //Assert
            fail("Edit order was valid. No exception should have been thrown");
        }
       
    }
    
}

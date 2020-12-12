/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook;

import com.mycompany.orderbook.controller.OrderBookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author bobur
 */
public class App {
//     public static void main(String[] args) {
//        
//        Controller contr = new Controller();
//        
//        contr.run();
//    }
    
        public static void main(String[] args) {

//        UserIO io = new UserIOImpl();
//        OrderBookView view = new OrderBookView(io);
//        OrderBookDaoImpl dao = new OrderBookDaoImpl();
//        List<Order> Buys = dao.GetBuyOrders();
//        List<Order> Sells = dao.GetSellOrders();
//
//        for(Order order : Buys) {
//            System.out.println(order.toString());
//        }
//        System.out.println("------------------------------");
//        for(Order order : Sells) {
//            System.out.println(order.toString());
//        }
//        System.out.println("------------------------------");
//        dao.MatchOrders();
//        for(Order order : Buys) {
//            System.out.println(order.toString());
//        }
//        System.out.println("------------------------------");
//        for(Order order : Sells) {
//            System.out.println(order.toString());
//        }
//        dao.MatchOrders();
//        dao.MatchOrders();
//        dao.MatchOrders();
//        dao.MatchOrders();
//        dao.MatchOrders();
//
//        List<Trade> trades = dao.TradesByExecutionTime();
//        for(Trade trade : trades) {
//            System.out.println(trade.toString());
//        }
//        trade.toString();
//        OrderBookController contr = new OrderBookController();
//        contr.run();

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.mycompany.orderbook");
        appContext.scan("com.mycompany.orderbook.controller");
        appContext.scan("com.mycompany.orderbook.dao");
        appContext.scan("com.mycompany.orderbook.view");
        appContext.scan("com.mycompany.orderbook.service");
        
        appContext.refresh();

        OrderBookController controller = appContext.getBean("orderBookController", OrderBookController.class);
        controller.run();
    }
}

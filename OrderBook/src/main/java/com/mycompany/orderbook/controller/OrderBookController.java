/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.orderbook.controller;

import com.mycompany.orderbook.dao.OrderBookDaoImpl;
import com.mycompany.orderbook.dto.Order;
import com.mycompany.orderbook.service.DataValidationException;
import com.mycompany.orderbook.service.DuplicateIDexception;
import com.mycompany.orderbook.service.ServiceLayer;
import com.mycompany.orderbook.service.ServiceLayerImpl;
import com.mycompany.orderbook.view.UserIO;
import com.mycompany.orderbook.view.UserIOImpl;
import com.mycompany.orderbook.view.OrderBookView;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mycompany.orderbook.dao.OrderBookDao;
import com.mycompany.orderbook.dao.OrderDaoException;
import java.io.IOException;

/**
 *
 * @author bobur
 */
@Component
public class OrderBookController {
    
    private OrderBookView view;
    private ServiceLayer service;

    @Autowired
    public OrderBookController(ServiceLayer service, OrderBookView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try{
        while (keepGoing) {
            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    viewOrderBook();
                    break;
                case 2:
                    matchSingleOrder();
                    break;
                case 3:
                    matchAllOrders();
                    break;
                case 4:
                    viewSingleTrade();
                    break;
                case 5:
                    viewTradesByExecTime();
                    break;
                case 6:
                    addOrder();
                    break;
                case 7:
                    editOrder();
                    break;
                case 8:
                    keepGoing = false;
                    break;
                default:
                    view.unknownCommand();
            }
        }
        view.exiting();
            
        }catch(OrderDaoException e){
            view.displayErrorMessage(e.getMessage());
        }catch(IOException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void viewOrderBook() {
        boolean keepgoing = true;
        while(keepgoing) {
            String pageNumber = view.getPageNumber();
            if(pageNumber.equals("e")) { break; }
            boolean isValid = true;
            for(int i = 0; i < pageNumber.length(); i++) {
                if(!Character.isDigit(pageNumber.charAt(i))) {
                    isValid = false;
                    break;
                }
            }
            double lastPage = Math.max(service.GetBuyOrders().size(), service.GetSellOrders().size());
            lastPage = (int) Math.ceil(lastPage/5);
            if(Integer.parseInt(pageNumber) > lastPage) { isValid = false; }
            if(isValid) {
                view.viewOrderBook((ArrayList<Order>) service.GetBuyOrders(), (ArrayList<Order>) service.GetSellOrders(), Integer.parseInt(pageNumber));
            }
            else {
                view.invalidInput();
            }
        }
        //view.viewOrderBook((ArrayList<Order>)service.GetBuyOrders(), (ArrayList<Order>)service.GetSellOrders(), 0);

    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void matchSingleOrder() {
        view.MatchOneOrderSuccess(true);

        view.DisplayTradeInfo(service.MatchOrders());
        
        view.displayStats();

        view.orderbookstats(service.OrderBookStats());
    }

    private void matchAllOrders() {
        view.displayMatchingAllOrders();
        String CreatedTradeRange = service.MatchAllOrders();
        view.DisplayCreatedTradeRange(CreatedTradeRange);
        view.orderbookstats(service.OrderBookStats());
    }

    private void viewSingleTrade() {
        String tradeID = view.GetTradeID();
        view.DisplayTradeInfo(service.GetTradeByID(tradeID));
    }

    private void viewTradesByExecTime() {
        
        view.DisplayTradesByExecutionTime(service.TradesByExecutionTime());
    }

    private void addOrder() throws OrderDaoException, IOException {
        try {
            String choice = view.buyOrSellOrder();
            Order order = view.getOrderInfo();
            if (choice.charAt(0) == 'B') {
                service.addBuyOrder(order);
                System.out.println(order.toString());
            } else if (choice.charAt(0) == 'S') {
                service.addSellOrder(order);
                System.out.println(order.toString());
            } else {
                view.invalidOrderInput();
            }
        } catch(DataValidationException | DuplicateIDexception e) {
            view.invalidOrderInput();
            addOrder();
        }
    }

    private void editOrder()  {
        try {
            String choice = view.buyOrSellOrder();
            List<String> orderInfo = view.getEditOrderInfo();
            Order order = service.editOrder(orderInfo, choice);
        } catch(DataValidationException | DuplicateIDexception e) {
            view.invalidOrderInput();
            editOrder();
        }
    }
}

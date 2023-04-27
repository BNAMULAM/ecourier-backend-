package com.ecourier.service;

import java.util.List;


import com.ecourier.entity.OrderEntity;

public interface OrderService {
    public OrderEntity placeOrder(OrderEntity placeorder)  ;
    public OrderEntity updateOrder(OrderEntity updateorder);
    public String cancelOrder(long id);
    List<OrderEntity> viewAllOrders();
    public OrderEntity viewOrderById(long trackingNumber);
    
    public List<OrderEntity> viewByUserName(String username);
  

}

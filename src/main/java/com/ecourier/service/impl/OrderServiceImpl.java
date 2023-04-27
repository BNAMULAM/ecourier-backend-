package com.ecourier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecourier.entity.OrderEntity;
import com.ecourier.repo.OrderRepository;
import com.ecourier.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepo;
    @Override
    public OrderEntity placeOrder(OrderEntity placeorder)  {
     return this.orderRepo.save(placeorder);

    }
    @Override
    public OrderEntity updateOrder(OrderEntity updateorder) {
        return this.orderRepo.save(updateorder);
    }
    @Override
    public String cancelOrder(long id) {
        this.orderRepo.deleteById(id);
        return "Order has been Cancelled";
    }
	@Override
	public List<OrderEntity> viewAllOrders() {
		List<OrderEntity> allOrders = this.orderRepo.findAll();
		return allOrders;
	}
	@Override
	 public OrderEntity viewOrderById(long trackingNumber) {
	 OrderEntity view = this.orderRepo.findById(trackingNumber).orElse(null);
	 return view;
	}
	@Override
	public List<OrderEntity> viewByUserName(String username) {
		// TODO Auto-generated method stub
		return orderRepo.findByName(username);
	}



}
package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Order;

public interface OrderService {
	public  void insertOrder(Order order);
	public void editOrder(Order order);
	public void removeOrder(String orderid);
	public void getOrder(String orderid);
	public  List<Order> getAllOrders();
}

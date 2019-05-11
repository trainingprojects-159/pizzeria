package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Orders;

public interface OrderService {
	public  void insertOrder(Orders order);
	public void editOrder(Orders order);
	public void removeOrder(String orderid);
	public Orders getByOrderId(String orderid);
	public  List<Orders> getAllOrders();
}

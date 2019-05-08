package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Order;



public interface OrderDao {
	public  void createOrder(Order order);
	public void updateOrder(Order order);
	public void deleteOrder(String orderid);
	public void acceptOrder(String orderid);
	public  List<Order> getAllOrders();
}

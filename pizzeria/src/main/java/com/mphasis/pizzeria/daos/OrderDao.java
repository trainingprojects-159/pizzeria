package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Orders;



public interface OrderDao {
	public  void createOrder(Orders order);
	public void updateOrder(Orders order);
	public void deleteOrder(String orderid);
	
	public  List<Orders> getAllOrders();
}

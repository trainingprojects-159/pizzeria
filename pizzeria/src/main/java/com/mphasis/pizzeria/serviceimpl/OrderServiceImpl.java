package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.OrderDao;
import com.mphasis.pizzeria.entities.Order;
import com.mphasis.pizzeria.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
	this.orderDao = orderDao;
}

	public void insertOrder(Order order) {
		orderDao.createOrder(order);
	}

	public void editOrder(Order order) {
		orderDao.updateOrder(order);
	}

	public void removeOrder(String orderid) {
		orderDao.deleteOrder(orderid);

	}

	public void getOrder(String orderid) {
		orderDao.acceptOrder(orderid);

	}

	public List<Order> getAllOrders() {
		
		return orderDao.getAllOrders();
	}

}

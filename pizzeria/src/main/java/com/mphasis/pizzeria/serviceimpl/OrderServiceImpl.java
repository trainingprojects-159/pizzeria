package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.OrderDao;
import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
@Autowired
OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao)throws BusinessException {
	this.orderDao = orderDao;
}

	public void insertOrder(Orders order)throws BusinessException {
		orderDao.createOrder(order);
	}

	public void editOrder(Orders order) throws BusinessException{
		orderDao.updateOrder(order);
	}

	public void removeOrder(String orderid)throws BusinessException {
		orderDao.deleteOrder(orderid);

	}

	
	public List<Orders> getAllOrders()throws BusinessException {
		
		return orderDao.getAllOrders();
	}

	public Orders getByOrderId(String orderid) throws BusinessException{
	
		return orderDao.getByOrderId(orderid);
	}

	

}

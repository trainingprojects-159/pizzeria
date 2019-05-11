package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.exception.BusinessException;

public interface OrderService {
	public  void insertOrder(Orders order)throws BusinessException;
	public void editOrder(Orders order)throws BusinessException;
	public void removeOrder(String orderid)throws BusinessException;
	public Orders getByOrderId(String orderid)throws BusinessException;
	public  List<Orders> getAllOrders()throws BusinessException;
}

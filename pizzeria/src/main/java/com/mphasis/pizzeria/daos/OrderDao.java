package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.exception.BusinessException;




public interface OrderDao {
	public  void createOrder(Orders order)throws BusinessException;
	public void updateOrder(Orders order)throws BusinessException;
	public void deleteOrder(String orderid)throws BusinessException;
	public Orders getByOrderId(String orderid)throws BusinessException;
	public  List<Orders> getAllOrders()throws BusinessException;
}

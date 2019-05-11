package com.mphasis.pizzeria.services;

import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.exception.BusinessException;

public interface CustomerService {
	public Customer login(String custid,String password)throws BusinessException;
	public void	 register(Customer customer)throws BusinessException;
	public Customer getByCustId(String custid)throws BusinessException;
}

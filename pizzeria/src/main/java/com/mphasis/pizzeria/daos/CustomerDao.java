package com.mphasis.pizzeria.daos;

import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.exception.BusinessException;
public interface CustomerDao {
	public Customer login(String custid,String password)throws BusinessException;
	public void	 register(Customer customer)throws BusinessException;
	public Customer getByCustId(String custid)throws BusinessException;
}
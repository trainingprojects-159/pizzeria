package com.mphasis.pizzeria.daos;

import com.mphasis.pizzeria.entities.Customer;
public interface CustomerDao {
	public Customer login(String custid,String password);
	public void	 register(Customer customer);
	public Customer getByCustId(String custid);
}
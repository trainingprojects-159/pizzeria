package com.mphasis.pizzeria.services;

import com.mphasis.pizzeria.entities.Customer;

public interface CustomerService {
	public Customer login(String custid,String password);
	public void	 register(Customer customer);
	public Customer getByCustId(String custid);
}

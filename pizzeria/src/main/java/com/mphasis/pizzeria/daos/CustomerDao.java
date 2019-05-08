package com.mphasis.pizzeria.daos;

import com.mphasis.pizzeria.entities.Customer;
public interface CustomerDao {
	public Customer login(String username,String password);
	public void	 register(Customer customer);
	
}
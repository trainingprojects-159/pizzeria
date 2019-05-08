package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.entities.ShoppingCart;


public interface CustomerDao {
	public Customer login(String username,String password);
	public void	 register(Customer customer);
	
}
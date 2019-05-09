package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.PizzaStore;

public interface AdminService {
	public  Admin login(String username,String password);
	

}

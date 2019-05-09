package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.PizzaStore;
public interface AdminDao {
	
public  Admin login(String username,String password);
}
                
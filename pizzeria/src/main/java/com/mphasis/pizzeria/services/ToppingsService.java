package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Toppings;


public interface ToppingsService {
	public void addTopping(Toppings topping);
	 public void modifyTopping(Toppings topping);
	 public void removeTopping(String toppingid);
	 public List<Toppings> getAll();
}

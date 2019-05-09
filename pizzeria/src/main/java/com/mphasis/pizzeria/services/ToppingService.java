package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Toppings;

public interface ToppingService {
	public void addTopping(Toppings topping);
	 public void editTopping(Toppings topping);
	 public void removeTopping(String toppingid);
	 public List<Toppings> getAllToppings();
}

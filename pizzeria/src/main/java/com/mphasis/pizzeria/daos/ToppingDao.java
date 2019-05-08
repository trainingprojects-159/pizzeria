package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Toppings;

public interface ToppingDao {
	 public void addTopping(Toppings topping);
	 public void updateTopping(Toppings topping);
	 public void deleteTopping(String toppingid);
	 public List<Toppings> getAllToppings();
}

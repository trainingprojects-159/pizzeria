package com.mphasis.pizzeria.daos;

import java.util.List;


import com.mphasis.pizzeria.entities.PizzaItems;



public interface PizzaStoreDao {
	public void login(String username,String password);
	public void insertPizzaItems(PizzaItems pizzaItems);
	public void updatePizzaItems(PizzaItems pizzaItems);
	public void deletePizzaItems(String pizzaid);
	public  List<PizzaItems> getAllPizzaItems();
	
}

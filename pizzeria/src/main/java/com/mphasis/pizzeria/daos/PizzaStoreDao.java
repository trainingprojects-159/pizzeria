package com.mphasis.pizzeria.daos;

import java.util.List;


import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;

public interface PizzaStoreDao {
	public PizzaStore login(String storeid,String password);
	public void insertPizzaItems(PizzaItems pizzaItems);
	public void updatePizzaItems(PizzaItems pizzaItems);
	public void deletePizzaItems(String pizzaid);
	public  List<PizzaItems> getAllPizzaItems();
	
}

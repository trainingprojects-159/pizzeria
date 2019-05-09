package com.mphasis.pizzeria.daos;

import java.util.List;


import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;

public interface PizzaStoreDao {
	public PizzaStore login(String storeid,String password);
	public void insertPizzaStore(PizzaStore pizzastore);
	public void updatePizzaStore(PizzaStore pizzastore);
	public void deletePizzaStore(String storeid);
	public  List<PizzaStore> getAllPizzaStore();
	
}
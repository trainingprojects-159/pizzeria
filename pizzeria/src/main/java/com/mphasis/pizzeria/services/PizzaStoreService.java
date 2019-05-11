package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;

public interface PizzaStoreService {
	public PizzaStore login(String storeid,String password);
	public void addPizzaStore(PizzaStore pizzastore);
	public void editPizzaStore(PizzaStore pizzastore);
	public void removePizzaStore(String storeid);
	public PizzaStore getByStoreId(String storeid);
	public PizzaStore getByManagerName(String manager_name);
	public  List<PizzaStore> getAllPizzaStore();
	
}

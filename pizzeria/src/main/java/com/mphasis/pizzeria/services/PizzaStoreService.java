package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;

public interface PizzaStoreService {
	public PizzaStore login(String storeid,String password)throws BusinessException;
	public void addPizzaStore(PizzaStore pizzastore)throws BusinessException;
	public void editPizzaStore(PizzaStore pizzastore)throws BusinessException;
	public void removePizzaStore(String storeid)throws BusinessException;
	public PizzaStore getByStoreId(String storeid)throws BusinessException;
	public PizzaStore getByManagerName(String manager_name)throws BusinessException;
	public  List<PizzaStore> getAllPizzaStore()throws BusinessException;
	
}

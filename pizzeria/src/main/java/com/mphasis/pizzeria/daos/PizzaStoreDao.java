package com.mphasis.pizzeria.daos;

import java.util.List;


import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;

public interface PizzaStoreDao {
	public PizzaStore login(String storeid,String password)throws BusinessException;
	public void insertPizzaStore(PizzaStore pizzastore)throws BusinessException;
	public void updatePizzaStore(PizzaStore pizzastore)throws BusinessException;
	public void deletePizzaStore(String storeid)throws BusinessException;
	public PizzaStore getByStoreId(String storeid)throws BusinessException;
	public PizzaStore getByManagerName(String manager_name)throws BusinessException;
	public  List<PizzaStore> getAllPizzaStore()throws BusinessException;
	
}

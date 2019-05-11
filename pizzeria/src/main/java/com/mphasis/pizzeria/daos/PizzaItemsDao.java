package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.exception.BusinessException;

public interface PizzaItemsDao {
	public void insertPizzaItems(PizzaItems pizzaItems)throws BusinessException;
	public void updatePizzaItems(PizzaItems pizzaItems)throws BusinessException;
	public void deletePizzaItems(String pizzaid)throws BusinessException;
	public PizzaItems getById(String pizzaid)throws BusinessException;
	public  List<PizzaItems> getAllPizzaItems()throws BusinessException;
	
}

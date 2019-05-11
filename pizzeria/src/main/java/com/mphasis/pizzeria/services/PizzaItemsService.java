package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.exception.BusinessException;

public interface PizzaItemsService {
	public void addPizzaItems(PizzaItems pizzaItems)throws BusinessException;
	public void editPizzaItems(PizzaItems pizzaItems)throws BusinessException;
	public void removePizzaItems(String pizzaid)throws BusinessException;
	public PizzaItems getById(String pizzaid)throws BusinessException;
	public  List<PizzaItems> getAllPizzaItems()throws BusinessException;
}

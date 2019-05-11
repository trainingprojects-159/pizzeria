package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.PizzaItems;

public interface PizzaItemsService {
	public void addPizzaItems(PizzaItems pizzaItems);
	public void editPizzaItems(PizzaItems pizzaItems);
	public void removePizzaItems(String pizzaid);
	public PizzaItems getById(String pizzaid);
	public  List<PizzaItems> getAllPizzaItems();
}

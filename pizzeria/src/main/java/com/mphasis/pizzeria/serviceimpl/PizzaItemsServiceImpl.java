package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.PizzaItemsDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.services.PizzaItemsService;
@Service
public class PizzaItemsServiceImpl implements PizzaItemsService {
@Autowired
PizzaItemsDao pizzaItemsDao;
	public void addPizzaItems(PizzaItems pizzaItems) {
		pizzaItemsDao.insertPizzaItems(pizzaItems);
	}

	public void editPizzaItems(PizzaItems pizzaItems) {
		pizzaItemsDao.updatePizzaItems(pizzaItems);
	}

	public void removePizzaItems(String pizzaid) {
		pizzaItemsDao.deletePizzaItems(pizzaid);
	}

	public List<PizzaItems> getAllPizzaItems() {
		
		return pizzaItemsDao.getAllPizzaItems();
	}

	public PizzaItems getById(String pizzaid) {
		
		return pizzaItemsDao.getById(pizzaid);
	}

	

}

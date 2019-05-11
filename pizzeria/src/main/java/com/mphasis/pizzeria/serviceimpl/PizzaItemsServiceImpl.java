package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.PizzaItemsDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.PizzaItemsService;
@Service
public class PizzaItemsServiceImpl implements PizzaItemsService {
@Autowired
PizzaItemsDao pizzaItemsDao;
	public void addPizzaItems(PizzaItems pizzaItems) throws BusinessException{
		pizzaItemsDao.insertPizzaItems(pizzaItems);
	}

	public void editPizzaItems(PizzaItems pizzaItems)throws BusinessException {
		pizzaItemsDao.updatePizzaItems(pizzaItems);
	}

	public void removePizzaItems(String pizzaid) throws BusinessException{
		pizzaItemsDao.deletePizzaItems(pizzaid);
	}

	public List<PizzaItems> getAllPizzaItems()throws BusinessException {
		
		return pizzaItemsDao.getAllPizzaItems();
	}

	public PizzaItems getById(String pizzaid) throws BusinessException{
		
		return pizzaItemsDao.getById(pizzaid);
	}

	

}

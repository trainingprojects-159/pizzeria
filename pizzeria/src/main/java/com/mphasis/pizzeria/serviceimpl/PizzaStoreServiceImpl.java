package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.PizzaStoreDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.services.PizzaStoreService;
@Service
public class PizzaStoreServiceImpl implements PizzaStoreService {
@Autowired
PizzaStoreDao pizzaStoreDao;

	public void setPizzaStoreDao(PizzaStoreDao pizzaStoreDao) {
	this.pizzaStoreDao = pizzaStoreDao;
}

	public PizzaStore login(String storeid, String password) {
		
		return pizzaStoreDao.login(storeid, password);
	}

	public void addPizzaStore(PizzaStore pizzastore) {
		pizzaStoreDao.insertPizzaStore(pizzastore);
	}

	public void editPizzaStore(PizzaStore pizzastore) {
		
		pizzaStoreDao.updatePizzaStore(pizzastore);
	}

	public void removePizzaStore(String storeid) {
		pizzaStoreDao.deletePizzaStore(storeid);
		
	}

	public List<PizzaStore> getAllPizzaStore() {
		
		return pizzaStoreDao.getAllPizzaStore();
	}

	

}

package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.PizzaStoreDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.PizzaStoreService;
@Service
public class PizzaStoreServiceImpl implements PizzaStoreService {
@Autowired
PizzaStoreDao pizzaStoreDao;

	public void setPizzaStoreDao(PizzaStoreDao pizzaStoreDao)throws BusinessException {
	this.pizzaStoreDao = pizzaStoreDao;
}

	public PizzaStore login(String storeid, String password)throws BusinessException {
		
		return pizzaStoreDao.login(storeid, password);
	}

	public void addPizzaStore(PizzaStore pizzastore)throws BusinessException {
		pizzaStoreDao.insertPizzaStore(pizzastore);
	}

	public void editPizzaStore(PizzaStore pizzastore) throws BusinessException {
		
		pizzaStoreDao.updatePizzaStore(pizzastore);
	}

	public void removePizzaStore(String storeid) throws BusinessException{
		pizzaStoreDao.deletePizzaStore(storeid);
		
	}

	public List<PizzaStore> getAllPizzaStore()throws BusinessException {
		
		return pizzaStoreDao.getAllPizzaStore();
	}

	public PizzaStore getByStoreId(String storeid) throws BusinessException{
		
		return pizzaStoreDao.getByStoreId(storeid);
	}

	public PizzaStore getByManagerName(String manager_name)throws BusinessException {
		
		return pizzaStoreDao.getByManagerName(manager_name);
	}

	

}

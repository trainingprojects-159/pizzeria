package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.ToppingDao;
import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.services.ToppingService;
@Service
public class ToppingServiceImpl implements ToppingService {
@Autowired
ToppingDao toppingDao;
	public void setToppingDao(ToppingDao toppingDao) {
	this.toppingDao = toppingDao;
}

	public void addTopping(Toppings topping) {
		toppingDao.insertTopping(topping);

	}

	public void editTopping(Toppings topping) {
		toppingDao.updateTopping(topping);

	}

	public void removeTopping(String toppingid) {
		toppingDao.deleteTopping(toppingid);

	}

	public List<Toppings> getAllToppings() {
		
		return toppingDao.getAllToppings();
	}

}

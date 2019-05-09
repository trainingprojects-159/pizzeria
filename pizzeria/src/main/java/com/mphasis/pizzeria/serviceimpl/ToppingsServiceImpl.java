package com.mphasis.pizzeria.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mphasis.pizzeria.daos.ToppingDao;
import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.services.ToppingsService;
@Component
public class ToppingsServiceImpl implements ToppingsService {
	@Autowired
	ToppingDao toppingDao;
	

	public void setToppingDao(ToppingDao toppingDao) {
		this.toppingDao = toppingDao;
	}
	public void addTopping(Toppings topping) {
		System.out.println("Order values in service"+topping.getToppingid());
		toppingDao.insertTopping(topping);

	}

	public void modifyTopping(Toppings topping) {
		toppingDao.updateTopping(topping);

	}

	public void removeTopping(String toppingid) {
		toppingDao.deleteTopping(toppingid);

	}

	public List<Toppings> getAll() {
		// TODO Auto-generated method stub
		return  toppingDao.getAllToppings();
	}

}
package com.mphasis.pizzeria.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mphasis.pizzeria.daos.ToppingDao;
import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.ToppingService;
@Component
public class ToppingServiceImpl implements ToppingService {
	@Autowired
	ToppingDao toppingDao;
	

	public void setToppingDao(ToppingDao toppingDao) {
		this.toppingDao = toppingDao;
	}
	public void addTopping(Toppings topping) throws BusinessException{
		System.out.println("Order values in service"+topping.getToppingid());
		toppingDao.insertTopping(topping);

	}

	public void modifyTopping(Toppings topping) throws BusinessException{
		toppingDao.updateTopping(topping);

	}

	public void removeTopping(String toppingid)throws BusinessException {
		toppingDao.deleteTopping(toppingid);

	}

	
	public void editTopping(Toppings topping) throws BusinessException{
		toppingDao.updateTopping(topping);
	}
	public List<Toppings> getAllToppings() throws BusinessException{
	 
		return toppingDao.getAllToppings();
	}
	public Toppings getByToppingId(String toppingid)throws BusinessException {
		
		return toppingDao.getByToppingId(toppingid);
	}

}

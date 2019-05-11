package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.exception.BusinessException;

public interface ToppingDao {
	 public void insertTopping(Toppings topping)throws BusinessException;
	 public void updateTopping(Toppings topping)throws BusinessException;
	 public void deleteTopping(String toppingid)throws BusinessException;
	 public Toppings getByToppingId(String toppingid)throws BusinessException;
	 public List<Toppings> getAllToppings()throws BusinessException;
}

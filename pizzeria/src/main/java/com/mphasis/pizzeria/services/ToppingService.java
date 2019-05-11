package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.exception.BusinessException;

public interface ToppingService {
	public void addTopping(Toppings topping)throws BusinessException;
	 public void editTopping(Toppings topping)throws BusinessException;
	 public void removeTopping(String toppingid)throws BusinessException;
	 public Toppings getByToppingId(String toppingid)throws BusinessException;
	 public List<Toppings> getAllToppings()throws BusinessException;
}

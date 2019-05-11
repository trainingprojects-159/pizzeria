package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.exception.BusinessException;

public interface ShoppingCartService {
	public void addToCart(ShoppingCart shoppingcart)throws BusinessException;
	 public void editToCart(ShoppingCart shoppingcart)throws BusinessException;
	 public void removeToCart(String cartid)throws BusinessException;
	 public ShoppingCart getByCartId(String cartid)throws BusinessException;
	 public List<ShoppingCart> getShoppingCarts()throws BusinessException;
}

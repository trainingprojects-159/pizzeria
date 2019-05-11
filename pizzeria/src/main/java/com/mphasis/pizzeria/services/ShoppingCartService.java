package com.mphasis.pizzeria.services;

import java.util.List;

import com.mphasis.pizzeria.entities.ShoppingCart;

public interface ShoppingCartService {
	public void addToCart(ShoppingCart shoppingcart);
	 public void editToCart(ShoppingCart shoppingcart);
	 public void removeToCart(String cartid);
	 public ShoppingCart getByCartId(String cartid);
	 public List<ShoppingCart> getShoppingCarts();
}

package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.Order;
import com.mphasis.pizzeria.entities.ShoppingCart;


public interface CustomerDao {
	public void login(String username,String password);
	public void addShoppingCart(ShoppingCart shoppingcart);
	public void updateShoppingCart(ShoppingCart pizzastore);
	public void deleteShoppingCart(String cartid);
	public  List <ShoppingCart> getAllShoppingCart();
}
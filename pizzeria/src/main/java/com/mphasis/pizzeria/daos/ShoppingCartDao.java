package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.ShoppingCart;

public interface ShoppingCartDao {
 public void insertToCart(ShoppingCart shoppingcart);
 public void updateToCart(ShoppingCart shoppingcart);
 public void deleteToCart(String cartid);
 public ShoppingCart getByCartId(String cartid);
 public List<ShoppingCart> getAllCarts();
}

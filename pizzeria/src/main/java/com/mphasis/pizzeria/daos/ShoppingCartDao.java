package com.mphasis.pizzeria.daos;

import java.util.List;

import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.exception.BusinessException;

public interface ShoppingCartDao {
 public void insertToCart(ShoppingCart shoppingcart)throws BusinessException;
 public void updateToCart(ShoppingCart shoppingcart)throws BusinessException;
 public void deleteToCart(String cartid)throws BusinessException;
 public ShoppingCart getByCartId(String cartid)throws BusinessException;
 public List<ShoppingCart> getAllCarts()throws BusinessException;
}

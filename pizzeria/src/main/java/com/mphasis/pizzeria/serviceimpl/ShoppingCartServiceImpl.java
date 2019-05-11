package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.ShoppingCartDao;
import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.services.ShoppingCartService;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
@Autowired
ShoppingCartDao shoppingCartDao;

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
	this.shoppingCartDao = shoppingCartDao;
}

	public void addToCart(ShoppingCart shoppingcart) {
		shoppingCartDao.insertToCart(shoppingcart);

	}

	public void editToCart(ShoppingCart shoppingcart) {
		shoppingCartDao.updateToCart(shoppingcart);

	}

	public void removeToCart(String cartid) {
		shoppingCartDao.deleteToCart(cartid);

	}

	public List<ShoppingCart> getShoppingCarts() {
		
		return shoppingCartDao.getAllCarts();
	}

	public ShoppingCart getByCartId(String cartid) {
		
		return shoppingCartDao.getByCartId(cartid);
	}

}

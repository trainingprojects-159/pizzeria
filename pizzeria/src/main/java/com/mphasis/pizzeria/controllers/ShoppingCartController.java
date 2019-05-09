package com.mphasis.pizzeria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.services.ShoppingCartService;





@RestController
public class ShoppingCartController {
	
	@Autowired
	ShoppingCartService shoppingCartService;

	
	
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	@RequestMapping(value="/shoppingcarts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ShoppingCart> listShoppingCarts()
	{	
		return shoppingCartService.getShoppingCarts();
    }
	
	@RequestMapping(value="/shoppingCart/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void  addToCar(@RequestBody ShoppingCart c)
	{
			this.shoppingCartService.addToCart(c);
			
	}
	
	@RequestMapping(value="/shoppingCart/{cartid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeToCart(@PathVariable("cartid")String cartid)
	{
			this.shoppingCartService.removeToCart(cartid);
		
	}
	
	@RequestMapping(value="/shoppingCart/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editToCart(@RequestBody ShoppingCart c)
	{
		this.shoppingCartService.editToCart(c);
		
	}
	
	
}

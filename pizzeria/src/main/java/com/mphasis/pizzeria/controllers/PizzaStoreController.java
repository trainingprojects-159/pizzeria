package com.mphasis.pizzeria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.pizzeria.entities.Order;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.services.OrderService;
import com.mphasis.pizzeria.services.PizzaItemsService;



@RestController
public class PizzaStoreController {
	
	
	
	@Autowired
	PizzaItemsService pizzaItemsService;

	

	public void setPizzaItemsService(PizzaItemsService pizzaItemsService) {
		this.pizzaItemsService = pizzaItemsService;
	}


	@RequestMapping(value="/pizzaitems",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PizzaItems> listPizzaItems()
	{
		
		return pizzaItemsService.getAllPizzaItems();
		
	}
	@RequestMapping(value="/pizzaitems/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)

		public void  addPizzaItems(@RequestBody PizzaItems pi)
		{
				this.pizzaItemsService.addPizzaItems(pi);
				
		}
	@RequestMapping(value="/pizzaitems/{storeid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removePizzaItems(@PathVariable("pizzaid")String pizzaid)
	{
			this.pizzaItemsService.removePizzaItems(pizzaid);
		
	}
	@RequestMapping(value="/pizzaitems/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editPizzaItems(@RequestBody PizzaItems pi)
	{
		this.pizzaItemsService.editPizzaItems(pi);
		
	}
	
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(value="/orders/get",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public void getOrder(@PathVariable("orderid")String orderid)
	{
		
		this.orderService.getOrder(orderid);
		
	}

	@RequestMapping(value="/orders/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editOrder(@RequestBody Order o)
	{
		this.orderService.editOrder(o);
		
	}
	
	
	

}

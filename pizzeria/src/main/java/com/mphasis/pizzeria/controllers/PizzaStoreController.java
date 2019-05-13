package com.mphasis.pizzeria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.Orders;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.OrderService;
import com.mphasis.pizzeria.services.PizzaItemsService;
import com.mphasis.pizzeria.services.PizzaStoreService;

@RestController
@RequestMapping("/pizzastore")
public class PizzaStoreController {
	
	
	@Autowired 
	PizzaStoreService pizzaStoreService;
	
	@Autowired
	PizzaItemsService pizzaItemsService;
	@Autowired
	OrderService orderService;
	
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public void setPizzaStoreService(PizzaStoreService pizzaStoreService) {
		this.pizzaStoreService = pizzaStoreService;
	}


	public void setPizzaItemsService(PizzaItemsService pizzaItemsService)throws BusinessException {
		this.pizzaItemsService = pizzaItemsService;
	}

	@RequestMapping(value="/login/{storeid}/{password}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public PizzaStore login(@PathVariable("storeid")String storeid,@PathVariable("password")String password) throws BusinessException {
		
		PizzaStore user=pizzaStoreService.login(storeid, password);
		return user;
	}
	@RequestMapping(value="/pizzaitems",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<PizzaItems> listPizzaItems()throws BusinessException
	{
		
		return pizzaItemsService.getAllPizzaItems();
		
	}
	
	@RequestMapping(value="/pizzaitems/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)

		public void  addPizzaItems(@RequestBody PizzaItems pi)throws BusinessException
		{
				this.pizzaItemsService.addPizzaItems(pi);
				
		}
	@RequestMapping(value="/pizzaitems/{storeid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removePizzaItems(@PathVariable("pizzaid")String pizzaid)throws BusinessException
	{
			this.pizzaItemsService.removePizzaItems(pizzaid);
		
	}
	@RequestMapping(value="/pizzaitems/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editPizzaItems(@RequestBody PizzaItems pi)throws BusinessException
	{
		this.pizzaItemsService.editPizzaItems(pi);
		
	}
	@RequestMapping(value="/pizzaItems/{pizzaid}", method=RequestMethod.GET)
	  public PizzaItems getByPizzaId(@PathVariable("pizzaid")String pizzaid) throws BusinessException
	  {
	  	
	  	return this.pizzaItemsService.getById(pizzaid);
	  }
	
	
	@RequestMapping(value="/orders/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editOrder(@RequestBody Orders o)throws BusinessException
	{
		this.orderService.editOrder(o);
		
	}
	
	@RequestMapping(value="/orders/{orderid}", method=RequestMethod.GET)
	  public Orders getByOrderId(@PathVariable("orderid")String orderid) throws BusinessException
	  {
	  	
	  	return this.orderService.getByOrderId(orderid);
	  }
	

}

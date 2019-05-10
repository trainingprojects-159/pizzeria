package com.mphasis.pizzeria.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.entities.Order;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.entities.Toppings;
import com.mphasis.pizzeria.services.CustomerService;
import com.mphasis.pizzeria.services.OrderService;
import com.mphasis.pizzeria.services.PizzaItemsService;
import com.mphasis.pizzeria.services.ShoppingCartService;
import com.mphasis.pizzeria.services.ToppingService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    
	@Autowired
	CustomerService customerService;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ToppingService toppingService;
	
	@Autowired
	PizzaItemsService pizzaItemsService;
	
	@Autowired
	OrderService orderService;

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public void setToppingService(ToppingService toppingService) {
		this.toppingService = toppingService;
	}
		
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setPizzaItemsService(PizzaItemsService pizzaItemsService) {
		this.pizzaItemsService = pizzaItemsService;
	}
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping(value="/login/{custid}/{password}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public void login(@PathVariable("custid")String custid,@PathVariable("password") String password)
	{
		this.customerService.login(custid, password);
	}
	@RequestMapping(value="/register",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public  void register(@RequestBody Customer customer)
	{
		this.customerService.register(customer);
	}
	
	@RequestMapping(value="/shoppingcarts",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<ShoppingCart> listShoppingCarts()
	{	
		return shoppingCartService.getShoppingCarts();
    }
	
	@RequestMapping(value="/shoppingCart/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void  addToCart(@RequestBody ShoppingCart c)
	{
			this.shoppingCartService.addToCart(c);		
	}
	
	@RequestMapping(value="/shoppingCart/{cartid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeToCart(@PathVariable("cartid")String cartid)
	{
			this.shoppingCartService.removeToCart(cartid);		
	}
	
	@RequestMapping(value="/shoppingCart/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateToCart(@RequestBody ShoppingCart c)
	{
		this.shoppingCartService.editToCart(c);	
	}
	
	@RequestMapping(value="/toppings",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Toppings> listToppings()
	{	
		return toppingService.getAllToppings();
    }
	
	@RequestMapping(value="/toppings/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void  addTopping(@RequestBody Toppings topping)
	{
			this.toppingService.addTopping(topping);		
	}
	
	@RequestMapping(value="/toppings/{toppingid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeTopping(@PathVariable("toppingid") String toppingid)
	{
			this.toppingService.removeTopping(toppingid);	
	}
	
	@RequestMapping(value="/toppings/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void updateTopping(@RequestBody Toppings topping)
	{
		this.toppingService.editTopping(topping);	
	}
	
	@RequestMapping(value="/orders",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Order> listOrders()
	{	
		return orderService.getAllOrders();
    }
	
	@RequestMapping(value="/orders/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public void  addOrder(@RequestBody Order order)
	{
			this.orderService.insertOrder(order);			
	}
	
	@RequestMapping(value="/orders/{orderid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	public void removeOrder(@PathVariable("orderid") String orderid)
	{
			this.orderService.removeOrder(orderid);		
	}
	
	@RequestMapping(value="/orders/edit",method=RequestMethod.PUT,produces=MediaType.APPLICATION_JSON_VALUE)
	public void editOrder(@RequestBody Order order){
		this.orderService.editOrder(order);	
	}

	@RequestMapping(value="/pizzaItems",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public  List<PizzaItems> listPizzaItems(){
			return pizzaItemsService.getAllPizzaItems();
	}
	
	
}


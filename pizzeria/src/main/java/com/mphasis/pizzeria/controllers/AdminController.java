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
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.AdminService;
import com.mphasis.pizzeria.services.OrderService;
import com.mphasis.pizzeria.services.PizzaStoreService;



@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService adminService;
	
	 @Autowired 
	 PizzaStoreService pizzaStoreService;
	 
	 @Autowired
	 OrderService orderService;
	 
	 public void setOrderService(OrderService orderService) {
	 	this.orderService = orderService;
	 }

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	  public void setPizzaStoreService(PizzaStoreService pizzaStoreService) {
		this.pizzaStoreService = pizzaStoreService;
	}
	  
	@RequestMapping(value="/login/{username}/{password}", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public Admin login(@PathVariable("username")String pname,@PathVariable("password")String pwd) throws BusinessException {
		
		Admin user=adminService.login(pname,pwd);
		return user;
	}

	@RequestMapping("/home")
	public String getPage() {
		return "index";
	}
	
	
	
	  @RequestMapping(value="/pizzastore",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
		public List<PizzaStore> listPizzaStores() throws BusinessException
		{	
			return pizzaStoreService.getAllPizzaStore();
	    }
	  @RequestMapping(value="/pizzastore/add",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
		public void  addPizzaStore(@RequestBody PizzaStore pizzastore) throws BusinessException
		{
				this.pizzaStoreService.addPizzaStore(pizzastore);
				
		}

	@RequestMapping(value="/pizzastore/{storeid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	  public void removePizzaStore(@PathVariable ("storeid") String storeid) throws BusinessException {
		  this.pizzaStoreService.removePizzaStore(storeid);
	  }
	
	  @RequestMapping(value="/pizzastore/edit",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	public void editpizzastore(@RequestBody PizzaStore p) throws BusinessException {
        this.pizzaStoreService.editPizzaStore(p);		
	}
	  @RequestMapping(value="pizzastore/{storeid}", method=RequestMethod.GET)
	  public PizzaStore getByStoreId(@PathVariable("storeid")String storeid) throws BusinessException
	  {
	  	
	  	return this.pizzaStoreService.getByStoreId(storeid);
	  }
	  @RequestMapping(value="pizzastore/{manager_name}", method=RequestMethod.GET)
	  public PizzaStore getByManagerName(@PathVariable("manager_name")String manager_name) throws BusinessException
	  {
	  	
	  	return this.pizzaStoreService.getByManagerName(manager_name);
	  }
	  
	  @RequestMapping(value="/order",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	  public List<Orders> listOrders() throws BusinessException
	  {	
		  return orderService.getAllOrders();
	  }

	  @RequestMapping(value="/order/{orderid}",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	  public void removeOrder(@PathVariable ("orderid") String orderid) throws BusinessException {
		  this.orderService.removeOrder(orderid);
	  }

	  @RequestMapping(value="/order/edit",method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_VALUE)
	  public void updateOrder(@RequestBody Orders order) throws BusinessException {
		  this.orderService.editOrder(order);	
	  }
	  @RequestMapping(value="order/{orderid}", method=RequestMethod.GET)
	  public Orders getByOrderId(@PathVariable("orderid")String orderid) throws BusinessException
	  {
	  	
	  	return this.orderService.getByOrderId(orderid);
	  }

}


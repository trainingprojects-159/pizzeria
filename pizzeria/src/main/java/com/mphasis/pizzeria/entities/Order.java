package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Order {

@Id
private String orderid;
@ManyToOne
@JoinColumn(name="username")
private Admin admin;

@ManyToOne
@JoinColumn(name="cartid")
private ShoppingCart shoppingCart;

@ManyToOne
@JoinColumn(name="storeid")
private PizzaStore pizzaStore;

@OneToMany(mappedBy="order",cascade=CascadeType.ALL)
private List<PizzaItems> pizzaItems; 

@ManyToOne
@JoinColumn(name="custid")
private Customer customer;

public String getOrderid() {
	return orderid;
}

public void setOrderid(String orderid) {
	this.orderid = orderid;
}

public Admin getAdmin() {
	return admin;
}

public void setAdmin(Admin admin) {
	this.admin = admin;
}

public ShoppingCart getShoppingCart() {
	return shoppingCart;
}

public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
}

public PizzaStore getPizzaStore() {
	return pizzaStore;
}

public void setPizzaStore(PizzaStore pizzaStore) {
	this.pizzaStore = pizzaStore;
}

public List<PizzaItems> getPizzaItems() {
	return pizzaItems;
}

public void setPizzaItems(List<PizzaItems> pizzaItems) {
	this.pizzaItems = pizzaItems;
}



private String status;

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}

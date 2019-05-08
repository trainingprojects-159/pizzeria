package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class PizzaItems {
@Id
private String pizzaid;
private String pizzaname;
private double pizzaprice;
private String pizzatype;
@ManyToOne
@JoinColumn(name="storeid")
private PizzaStore pizzaStore;

@OneToMany(mappedBy="pizzaItems",cascade=CascadeType.ALL)
private List<Toppings> toppings;

@ManyToOne
@JoinColumn(name="cartid")
private ShoppingCart shoppingCart;

@ManyToOne
@JoinColumn(name="custid")
private Customer customer;

@ManyToOne
@JoinColumn(name="orderid")
private Order order;


public ShoppingCart getShoppingCart() {
	return shoppingCart;
}

public void setShoppingCart(ShoppingCart shoppingCart) {
	this.shoppingCart = shoppingCart;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public Order getOrder() {
	return order;
}

public void setOrder(Order order) {
	this.order = order;
}

public List<Toppings> getToppings() {
	return toppings;
}

public void setToppings(List<Toppings> toppings) {
	this.toppings = toppings;
}

public String getPizzaid() {
	return pizzaid;
}

public void setPizzaid(String pizzaid) {
	this.pizzaid = pizzaid;
}

public String getPizzaname() {
	return pizzaname;
}

public void setPizzaname(String pizzaname) {
	this.pizzaname = pizzaname;
}

public double getPizzaprice() {
	return pizzaprice;
}

public void setPizzaprice(double pizzaprice) {
	this.pizzaprice = pizzaprice;
}

public String getPizzatype() {
	return pizzatype;
}

public void setPizzatype(String pizzatype) {
	this.pizzatype = pizzatype;
}

public PizzaStore getPizzaStore() {
	return pizzaStore;
}

public void setPizzaStore(PizzaStore pizzaStore) {
	this.pizzaStore = pizzaStore;
}


}

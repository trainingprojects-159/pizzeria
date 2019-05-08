package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class ShoppingCart {
@Id
private String cartid;
private double unitprice;
private int quantity;
private double totalprice;
@OneToMany(mappedBy="shoppingCart",cascade=CascadeType.ALL)
private List<PizzaItems> pizzaitems;

@OneToMany(mappedBy="shoppingCart",cascade=CascadeType.ALL)
private List<Order> order;

@OneToOne
@JoinColumn(name="custid")
private Customer customer;

public List<PizzaItems> getPizzaitems() {
	return pizzaitems;
}
public void setPizzaitems(List<PizzaItems> pizzaitems) {
	this.pizzaitems = pizzaitems;
}
public List<Order> getOrder() {
	return order;
}
public void setOrder(List<Order> order) {
	this.order = order;
}
public String getCartid() {
	return cartid;
}
public void setCartid(String cartid) {
	this.cartid = cartid;
}
public double getUnitprice() {
	return unitprice;
}
public void setUnitprice(double unitprice) {
	this.unitprice = unitprice;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalprice() {
	return totalprice;
}
public void setTotalprice(double totalprice) {
	this.totalprice = totalprice;
}

public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

}

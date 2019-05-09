package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator;
@Entity
public class ShoppingCart {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cartid_seq")
@GenericGenerator(
    name = "cartid_seq", 
    strategy = "com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator", 
    parameters = {
        @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "FI"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
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

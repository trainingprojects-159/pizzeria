package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
        @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "CI"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
private String cartid;
private double price;
private int quantity;
@OneToOne
private Customer customer;

@OneToMany(cascade=CascadeType.ALL)
private List<PizzaItems> pizzaitems;

@OneToMany(mappedBy="shoppingCart",cascade=CascadeType.ALL)
private List<Orders> order;

public String getCartid() {
	return cartid;
}

public void setCartid(String cartid) {
	this.cartid = cartid;
}

public double getPrice() {
	return price;
}

public void setPrice(double price) {
	this.price = price;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

public List<PizzaItems> getPizzaitems() {
	return pizzaitems;
}

public void setPizzaitems(List<PizzaItems> pizzaitems) {
	this.pizzaitems = pizzaitems;
}

public List<Orders> getOrder() {
	return order;
}

public void setOrder(List<Orders> order) {
	this.order = order;
}




}

package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.*;

import com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator;


@Entity
public class Order {
@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderid_seq")
    @GenericGenerator(
        name = "orderid_seq", 
        strategy = "com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "OI"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
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

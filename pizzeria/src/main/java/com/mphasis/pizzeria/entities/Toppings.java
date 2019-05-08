package com.mphasis.pizzeria.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Toppings {
	@Id
	private String toppingid;
	private String toppingname;

	@ManyToOne
	@JoinColumn(name="pizzaid")
	private PizzaItems pizzaItems;


	public String getToppingid() {
		return toppingid;
	}


	public void setToppingid(String toppingid) {
		this.toppingid = toppingid;
	}


	public String getToppingname() {
		return toppingname;
	}


	public void setToppingname(String toppingname) {
		this.toppingname = toppingname;
	}


	public PizzaItems getPizzaItems() {
		return pizzaItems;
	}


	public void setPizzaItems(PizzaItems pizzaItems) {
		this.pizzaItems = pizzaItems;
	}
	
	

}

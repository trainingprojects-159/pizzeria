package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class PizzaStoreLogin {
@OneToOne
private List<PizzaStore> pizzaStore;
private String password;


public List<PizzaStore> getPizzaStore() {
	return pizzaStore;
}
public void setPizzaStore(List<PizzaStore> pizzaStore) {
	this.pizzaStore = pizzaStore;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}



}

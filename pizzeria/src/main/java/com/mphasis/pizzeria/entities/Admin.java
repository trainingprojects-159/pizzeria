package com.mphasis.pizzeria.entities;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Admin {
@Id
private String username;
private String password;

@OneToMany(mappedBy="admin", fetch=FetchType.LAZY,cascade=CascadeType.ALL)
private  List<PizzaStore> pizzaStore;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<PizzaStore> getPizzaStore() {
	return pizzaStore;
}
public void setPizzaStore(List<PizzaStore> pizzaStore) {
	this.pizzaStore = pizzaStore;
}



}


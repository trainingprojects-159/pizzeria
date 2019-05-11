package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Customer {

	@Id
	private String custid;
	private String custname;
	private String email;
	private long phoneno;
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<PizzaItems> pizzaItems;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Orders> order;
	
	
	public List<PizzaItems> getPizzaItems() {
		return pizzaItems;
	}
	public void setPizzaItems(List<PizzaItems> pizzaItems) {
		this.pizzaItems = pizzaItems;
	}
	public List<Orders> getOrder() {
		return order;
	}
	public void setOrder(List<Orders> order) {
		this.order = order;
	}
	public String getCustid() {
		return custid;
	}
	public void setCustid(String custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}

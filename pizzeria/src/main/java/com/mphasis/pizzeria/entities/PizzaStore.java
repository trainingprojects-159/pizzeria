package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator;


@Entity
public class PizzaStore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "storeid_seq")
    @GenericGenerator(
        name = "storeid_seq", 
        strategy = "com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator", 
        parameters = {
            @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "SI"),
            @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
	private String storeid;
	private String storename;
	private String city;
	private String state;
	private String password;

	@ManyToOne
	@JoinColumn(name= "username")
	private Admin admin;
	
	@OneToMany(mappedBy="pizzaStore",cascade=CascadeType.ALL)
	private List<Order> order;
	
	@OneToMany(mappedBy="pizzaStore",cascade=CascadeType.ALL)
	private List<PizzaItems> pizzaItems;
	
	public List<PizzaItems> getPizzaItems() {
		return pizzaItems;
	}
	public void setPizzaItems(List<PizzaItems> pizzaItems) {
		this.pizzaItems = pizzaItems;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}

	public String getStoreid() {
		return storeid;
	}
	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}
	public String getStorename() {
		return storename;
	}
	public void setStorename(String storename) {
		this.storename = storename;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	
	

}

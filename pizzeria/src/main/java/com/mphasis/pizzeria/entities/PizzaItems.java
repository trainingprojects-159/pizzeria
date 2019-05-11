package com.mphasis.pizzeria.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator;
@Entity
public class PizzaItems {
@Id
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizzaid_seq")
@GenericGenerator(
    name = "pizzaid_seq", 
    strategy = "com.mphasis.pizzeria.util.StringPrefixedSequenceIdGenerator", 
    parameters = {
        @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "4"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PI"),
        @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d") })
private String pizzaid;
private String pizzaname;
private double pizzaprice;
private String pizzatype;
@ManyToOne
private PizzaStore pizzaStore;

@OneToMany(mappedBy="pizzaItems",cascade=CascadeType.ALL)
private List<Toppings> toppings;



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

public List<Toppings> getToppings() {
	return toppings;
}

public void setToppings(List<Toppings> toppings) {
	this.toppings = toppings;
}



}

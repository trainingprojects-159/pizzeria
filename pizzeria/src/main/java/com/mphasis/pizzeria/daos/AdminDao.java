package com.mphasis.pizzeria.daos;

import java.util.List;
import com.mphasis.pizzeria.entities.PizzaStore;
public interface AdminDao {
public void login(String username,String password);
public void addPizzaStore(PizzaStore pizzastore);
public void updatePizzaStore(PizzaStore pizzastore);
public void deletePizzaStore(String storeid);
public  List <PizzaStore> getAllPizzaStore(String city);

}

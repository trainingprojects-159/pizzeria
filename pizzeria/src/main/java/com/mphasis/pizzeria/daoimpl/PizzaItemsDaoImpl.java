package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.PizzaItemsDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;
@Repository
public class PizzaItemsDaoImpl implements PizzaItemsDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	public void insertPizzaItems(PizzaItems pizzaItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
 System.out.println(pizzaItems.getPizzaname()+"pizzaItems values in dao");
 session.save(pizzaItems);
 tr.commit();

	}

	public void updatePizzaItems(PizzaItems pizzaItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(pizzaItems);
		  tr.commit();
	}

	public void deletePizzaItems(String pizzaid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore pizzaItems=(PizzaStore) session.get(PizzaStore.class, pizzaid);
		  session.delete(pizzaItems);
		  tr.commit();

	}

	public List<PizzaItems> getAllPizzaItems() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 List<PizzaItems> pizzaitems = session.createCriteria(PizzaStore.class).list();
		  tr.commit();
		return pizzaitems;
		
	}
}

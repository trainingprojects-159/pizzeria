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
import com.mphasis.pizzeria.exception.BusinessException;
@Repository
public class PizzaItemsDaoImpl implements PizzaItemsDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	public void insertPizzaItems(PizzaItems pizzaItems)throws BusinessException {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
 System.out.println(pizzaItems.getPizzaname()+"pizzaItems values in dao");
 session.save(pizzaItems);
 tr.commit();

	}

	public void updatePizzaItems(PizzaItems pizzaItems)throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(pizzaItems);
		  tr.commit();
	}

	public void deletePizzaItems(String pizzaid)throws BusinessException {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaItems pizzaItems=(PizzaItems) session.get(PizzaItems.class, pizzaid);
		  session.delete(pizzaItems);
		  tr.commit();

	}

	public List<PizzaItems> getAllPizzaItems() throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 List<PizzaItems> pizzaitems = session.createQuery("from PizzaItems",PizzaItems.class).list();
		  tr.commit();
		return pizzaitems;
		
	}
	public PizzaItems getById(String pizzaid) throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaItems pizzaItems=(PizzaItems) session.get(PizzaItems.class, pizzaid);
		  tr.commit();
		return pizzaItems;
		
	}
}

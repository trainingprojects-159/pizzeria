package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.mphasis.pizzeria.daos.PizzaStoreDao;
import com.mphasis.pizzeria.entities.PizzaItems;
import com.mphasis.pizzeria.entities.PizzaStore;

public class PizzaStoreDaoImpl implements PizzaStoreDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	public void addPizzaItems(PizzaItems pizzaItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
  System.out.println(pizzaItems.getPizzaname()+"pizzaItems values in dao");
  session.save(pizzaItems);
  tr.commit();

	}

	public void updatePizzaItems(PizzaItems pizzaItems) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore p=(PizzaStore) session.get(PizzaItems.class, pizzaItems.getPizzaid());
		  session.update(pizzaItems);
		  tr.commit();
	}

	public void deletePizzaItems(String pizzaid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaItems pizzaItems=(PizzaItems) session.get(PizzaItems.class, pizzaid);
		  session.delete(pizzaItems);
		  tr.commit();

	}

	public List<PizzaItems> getAllPizzaItems() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  Criteria cri=session.createCriteria(PizzaItems.class);
		  
		  List<PizzaItems> pizzaItems=cri.list();
		  tr.commit();
		return null;
	}
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	public void acceptOrder(String orderid) {
		// TODO Auto-generated method stub
		
	}
	public void cancelOrder(String orderid) {
		// TODO Auto-generated method stub
		
	}

}

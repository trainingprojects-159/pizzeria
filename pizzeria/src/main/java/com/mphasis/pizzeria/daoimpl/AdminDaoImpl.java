package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Order;
import com.mphasis.pizzeria.entities.PizzaStore;



public class AdminDaoImpl implements AdminDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	public void addPizzaStore(PizzaStore pizzastore) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
  System.out.println(pizzastore.getStorename()+"pizzastore values in dao");
  session.save(pizzastore);
  tr.commit();
  

	}

	public void updatePizzaStore(PizzaStore pizzastore) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore p=(PizzaStore) session.get(PizzaStore.class, pizzastore.getStoreid());
		pizzastore.setState("state");
		  session.update(pizzastore);
		  tr.commit();	
	}

	public void deletePizzaStore(String storeid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore pizzastore=(PizzaStore) session.get(PizzaStore.class, storeid);
		  session.delete(pizzastore);
		  tr.commit();

	}

	public List<PizzaStore> getAllPizzaStore(String city) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  Criteria cri=session.createCriteria(PizzaStore.class);
		  cri.add(Restrictions.eq("city",city ));
		  List<PizzaStore> pizzaStore=cri.list();
		  tr.commit();
		return null;
	}
	public void acceptOrder(String orderid) {
		// TODO Auto-generated method stub
		
	}
	public void cancelOrder(String orderid) {
		// TODO Auto-generated method stub
		
	}
	public void login(String username, String password) {
		// TODO Auto-generated method stub
		
	}
	public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}

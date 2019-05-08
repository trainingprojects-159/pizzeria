package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.PizzaStore;
@Repository
@Transactional
public class AdminDaoImpl implements AdminDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	public void insertPizzaStore(PizzaStore pizzastore) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
      System.out.println(pizzastore.getStorename()+"pizzastore values in dao");
       session.save(pizzastore);
            tr.commit();
  
	}

	public void updatePizzaStore(PizzaStore pizzastore) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
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

	
	public Admin login(String username, String password) {
		Session session=(sessionFactory).openSession();
		
	Query query= session.createQuery("from Admin where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password",password);
		Admin admin=(Admin) query.uniqueResult();
	     return admin;
		
	}
	public List<PizzaStore> getAllPizzaStore() {
		Session session=(sessionFactory).openSession();
		Transaction tr=session.beginTransaction();
		 List<PizzaStore> pizzastores=session.createCriteria(PizzaStore.class).list();
		  tr.commit();
		return pizzastores;
	}
	
}

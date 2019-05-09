package com.mphasis.pizzeria.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.PizzaStore;
@Repository

public class AdminDaoImpl implements AdminDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	
	
	public Admin login(String username, String password) {
		Session session=(sessionFactory).openSession();
		
	Query query= session.createQuery("from Admin where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password",password);
		Admin admin=(Admin) query.uniqueResult();
	     return admin;
		
	}
	
	
}

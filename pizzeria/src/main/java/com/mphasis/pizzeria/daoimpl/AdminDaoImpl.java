package com.mphasis.pizzeria.daoimpl;



import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;

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
		TypedQuery<Admin> query=session.createQuery("from Admin where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password",password);
		Admin admin=(Admin) query.getSingleResult();
	     return admin;		
	}
	
	
}

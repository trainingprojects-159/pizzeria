package com.mphasis.pizzeria.daoimpl;



import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.exception.BusinessException;

@Repository

public class AdminDaoImpl implements AdminDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	 
	
	
	public Admin login(String username, String password)throws BusinessException {
		Session session=(sessionFactory).openSession();
		TypedQuery<Admin> query=session.createQuery("from Admin where username=:username and password=:password");
		query.setParameter("username", username);
		query.setParameter("password",password);
		Admin admin=(Admin) query.getSingleResult();
		if(admin==null)
	throw new BusinessException("object not created");
     return admin;		
	}
	
	
}

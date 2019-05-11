package com.mphasis.pizzeria.daoimpl;

import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.CustomerDao;
import com.mphasis.pizzeria.entities.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao{
	
	SessionFactory sessionFactory;
	@Autowired
	
public void setSessionFactory(SessionFactory sessionFactory)
{
	this.sessionFactory = sessionFactory;
}

	
	public Customer login(String username, String password) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		TypedQuery<Customer> query=session.createQuery("from Customer where username=:uname and password=:pass");
		query.setParameter("uname", username);
		query.setParameter("pass", password);
		Customer customer=(Customer) query.getSingleResult();
		return customer;
	}

	public void register(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		
	}

}

 package com.mphasis.pizzeria.daoimpl;

import javax.persistence.TypedQuery;
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

	
	public Customer login(String custid, String password) {
		Session session=sessionFactory.openSession();
		TypedQuery<Customer> query=session.createQuery("from Customer where custid=:custid and password=:password");
		query.setParameter("custid", custid);
		query.setParameter("password", password);
		Customer customer=(Customer) query.getSingleResult();
		return customer;
	}

	public void register(Customer customer) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		
	}


	public Customer getByCustId(String custid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Customer customer=(Customer) session.get(Customer.class, custid);
		  tr.commit();
		return customer;
	}

}

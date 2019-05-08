package com.mphasis.pizzeria.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.OrderDao;
import com.mphasis.pizzeria.entities.Order;
@Repository

public class OrderDaoImpl implements OrderDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	

	public void createOrder(Order order) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
      System.out.println(order.getOrderid()+"order values in dao");
       session.save(order);
            tr.commit();

	}

	public void updateOrder(Order order) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(order);
		  tr.commit();	

	}

	public void deleteOrder(String orderid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Order order=(Order) session.get(Order.class, orderid);
		  session.delete(order);
		  tr.commit();	

	}

	public void acceptOrder(String orderid) {
		Session session=(sessionFactory).openSession();
		Transaction tr=session.beginTransaction();
		Order order=(Order) session.get(Order.class, orderid);
		  session.save(order);
		  tr.commit();	

	}

	public List<Order> getAllOrders() {
		Session session=(sessionFactory).openSession();
		Transaction tr=session.beginTransaction();
		 List<Order> order=session.createCriteria(Order.class).list();
		  tr.commit();
		return order;
		
	}

}

package com.mphasis.pizzeria.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.OrderDao;
import com.mphasis.pizzeria.entities.Orders;

@Repository

public class OrderDaoImpl implements OrderDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	

	public void createOrder(Orders order) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
      System.out.println(order.getOrderid()+"order values in dao");
       session.save(order);
            tr.commit();

	}

	public void updateOrder(Orders order) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(order);
		  
		  tr.commit();	

	}

	public void deleteOrder(String orderid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Orders order=(Orders) session.get(Orders.class, orderid);
		  session.delete(order);
		  tr.commit();	

	}

	public List<Orders> getAllOrders() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 List<Orders> order=session.createQuery("from Orders",Orders.class).list();
		  tr.commit();
		return order;
		
	}

	public Orders getByOrderId(String orderid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  Orders order=(Orders) session.get(Orders.class, orderid);
		  tr.commit();
		return order;
		
	}

}

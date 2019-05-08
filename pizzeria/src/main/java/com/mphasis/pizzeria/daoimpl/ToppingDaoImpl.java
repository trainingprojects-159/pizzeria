package com.mphasis.pizzeria.daoimpl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.ToppingDao;
import com.mphasis.pizzeria.entities.Toppings;
@Repository
public class ToppingDaoImpl implements ToppingDao{
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	
	public void insertTopping(Toppings topping) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
      System.out.println(topping.getToppingname()+"toppings values in dao");
       session.save(topping);
            tr.commit();
	}

	public void updateTopping(Toppings topping) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(topping);
		  tr.commit();	
		
	}

	public void deleteTopping(String toppingid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		Toppings toppings=(Toppings) session.get(Toppings.class, toppingid);
		  session.delete(toppings);
		  tr.commit();

	}

	public List<Toppings> getAllToppings() {
		Session session=(sessionFactory).openSession();
		Transaction tr=session.beginTransaction();
		 List<Toppings> toppings=session.createCriteria(Toppings.class).list();
		  tr.commit();
		return toppings;
		
	}

}

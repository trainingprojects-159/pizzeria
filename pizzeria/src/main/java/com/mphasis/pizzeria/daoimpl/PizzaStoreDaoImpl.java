package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.PizzaStoreDao;
import com.mphasis.pizzeria.entities.PizzaStore;
@Repository

public class PizzaStoreDaoImpl implements PizzaStoreDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	
	public PizzaStore login(String storeid, String password) {
		Session session=sessionFactory.openSession();
		
		Query query= session.createQuery("from PizzaStore where storeid=:storeid and password=:password");
			query.setParameter("storeid", storeid);
			query.setParameter("password",password);
			PizzaStore pizzaStore=(PizzaStore) query.uniqueResult();
		     return pizzaStore;
		
		
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
	public List<PizzaStore> getAllPizzaStore() {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 List<PizzaStore> pizzastores=session.createQuery("from PizzaStore",PizzaStore.class).list();
		  tr.commit();
		return pizzastores;
	}
	public PizzaStore getByStoreId(String storeid) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore pizzaStore=(PizzaStore) session.get(PizzaStore.class, storeid);
		  tr.commit();
		return pizzaStore;
		
	}
	public PizzaStore getByManagerName(String manager_name) {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		PizzaStore pizzaStore=(PizzaStore) session.get(PizzaStore.class, manager_name);
		  tr.commit();
		return pizzaStore;
	}
	

}

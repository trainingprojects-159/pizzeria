package com.mphasis.pizzeria.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mphasis.pizzeria.daos.ShoppingCartDao;
import com.mphasis.pizzeria.entities.ShoppingCart;
import com.mphasis.pizzeria.exception.BusinessException;

@Repository
public class ShoppingCartDaoImpl implements ShoppingCartDao {
	@Autowired
	 SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}	
	public void insertToCart(ShoppingCart shoppingcart)throws BusinessException {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
  System.out.println(shoppingcart.getQuantity()+"shoppingcart values in dao");
  session.save(shoppingcart);
  tr.commit();

	}

	public void updateToCart(ShoppingCart shoppingcart) throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		  session.update(shoppingcart);
		  tr.commit();

	}

	public void deleteToCart(String cartid) throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		ShoppingCart shoppingcart=(ShoppingCart) session.get(ShoppingCart.class, cartid);
		  session.delete(shoppingcart);
		  tr.commit();

	}

	public List<ShoppingCart> getAllCarts() throws BusinessException{
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		 List<ShoppingCart> shoppingcart = session.createQuery("from ShoppingCart",ShoppingCart.class).list();
		  tr.commit();
		return shoppingcart;
	}
	public ShoppingCart getByCartId(String cartid)throws BusinessException {
		Session session=sessionFactory.openSession();
		Transaction tr=session.beginTransaction();
		ShoppingCart shoppingcart=(ShoppingCart) session.get(ShoppingCart.class, cartid);
		  tr.commit();
		  return shoppingcart;
	}

}

package com.mphasis.pizzeria.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.CustomerDao;
import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.services.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
	this.customerDao = customerDao;
}

	public Customer login(String custid, String password) {
		
		return customerDao.login(custid, password);
	}

	public void register(Customer customer) {
		customerDao.register(customer);
		
	}

	public Customer getByCustId(String custid) {
		
		return customerDao.getByCustId(custid);
	}

	
}

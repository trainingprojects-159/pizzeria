package com.mphasis.pizzeria.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.CustomerDao;
import com.mphasis.pizzeria.entities.Customer;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
@Autowired
CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao)throws BusinessException {
	this.customerDao = customerDao;
}

	public Customer login(String custid, String password) throws BusinessException{
		Customer customer=null;
		if(custid != null && custid.matches("[a-zA-Z]{4,15}"))
		{
			if(password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				customer=customerDao.login(custid, password);
			}
			else {
				throw new BusinessException("Entered password " + password + " is invalid");
			}
		}
		else {
			throw new BusinessException("Entered email " + custid + " is invalid");
		}
		
		return customer;
	}

	public void register(Customer customer)throws BusinessException {
		customerDao.register(customer);
		
	}

	public Customer getByCustId(String custid)throws BusinessException {
		
		return customerDao.getByCustId(custid);
	}

	
}

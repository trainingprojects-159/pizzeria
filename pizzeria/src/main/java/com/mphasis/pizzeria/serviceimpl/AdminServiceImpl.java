package com.mphasis.pizzeria.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.entities.PizzaStore;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
@Autowired
AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao){
	this.adminDao = adminDao;
}

	public Admin login(String username, String password)throws BusinessException {
		
		return adminDao.login(username, password);
	}

	

}

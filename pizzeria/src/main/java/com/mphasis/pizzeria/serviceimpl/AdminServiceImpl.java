package com.mphasis.pizzeria.serviceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.pizzeria.daos.AdminDao;
import com.mphasis.pizzeria.entities.Admin;
import com.mphasis.pizzeria.exception.BusinessException;
import com.mphasis.pizzeria.services.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
@Autowired
AdminDao adminDao;

	public void setAdminDao(AdminDao adminDao) {
	this.adminDao = adminDao;
}
	public Admin login(String username, String password)throws BusinessException {
		Admin admin = null;
		if(username != null && username.matches("[a-zA-Z]{4,15}"))
		{
			if(password != null && password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,10}$"))
			{
				admin=adminDao.login(username, password);
			}
			else {
				throw new BusinessException("Entered password " + password + " is invalid");
			}
		}
		else {
			throw new BusinessException("Entered email " + username + " is invalid");
		}
		return admin;
	}

	

}

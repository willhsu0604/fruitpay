package com.fruitpay.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruitpay.base.comm.returndata.ReturnMessageEnum;
import com.fruitpay.base.dao.CustomerDAO;
import com.fruitpay.base.model.Customer;
import com.fruitpay.base.service.LoginService;
import com.fruitpay.comm.model.ReturnData;
import com.fruitpay.comm.utils.Md5Util;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	@Qualifier("CustomerDAOImpl")
	CustomerDAO customerDAO;

	@Override
	@Transactional
	public ReturnData signup(Customer customer) {

		if(customerDAO.isEmailExisted(customer.getEmail())){
			return ReturnMessageEnum.Login.EmailAlreadyExisted.getReturnMessage();
		}else{
			customer = getEncodedPasswordCustomer(customer);
			customerDAO.create(customer); 
			
			return ReturnMessageEnum.Common.Success.getReturnMessage();
		}
	}
	//加密密碼
	private Customer getEncodedPasswordCustomer(Customer customer){
		 customer.setPassword(Md5Util.getMd5(customer.getPassword()));
		 return customer;
	}

	@Override
	public ReturnData login(String email, String password) {

		if(!customerDAO.isEmailExisted(email)){
			return ReturnMessageEnum.Login.EmailNotFound.getReturnMessage();
		}else if(!customerDAO.isEmailMatchPassword(email, password)){
			return ReturnMessageEnum.Login.EmailNotFound.getReturnMessage();
		}else{
			return ReturnMessageEnum.Common.Success.getReturnMessage();
		}
	}
	
	
}

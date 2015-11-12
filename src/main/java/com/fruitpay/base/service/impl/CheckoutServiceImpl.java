package com.fruitpay.base.service.impl;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fruitpay.base.comm.OrderStatus;
import com.fruitpay.base.dao.CustomerOrderDAO;
import com.fruitpay.base.dao.OrderProgramDAO;
import com.fruitpay.base.model.CustomerOrder;
import com.fruitpay.base.model.OrderProgram;
import com.fruitpay.base.service.CheckoutService;

@Service
public class CheckoutServiceImpl implements CheckoutService {
	
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Inject
	private CustomerOrderDAO customerOrderDAO;
	@Inject
	private OrderProgramDAO orderProgramDAO;
	
	@Override
	@Transactional
	public CustomerOrder checkoutOrder(CustomerOrder customerOrder) {
		logger.debug("add a customerOrder, email is " + customerOrder.getCustomer().getEmail());
		customerOrder = customerOrderDAO.create(customerOrder);
		
		OrderProgram orderProgram = orderProgramDAO.findById(customerOrder.getOrderProgram().getProgramId());
		customerOrder.setOrderProgram(orderProgram);
		
		return customerOrder;
	}

	@Override
	public CustomerOrder getCustomerOrder(Integer orderId) {
		return customerOrderDAO.findById(orderId);
	}

	@Override
	@Transactional
	public Boolean updateOrderStatus(Integer orderId, OrderStatus orderStatus) {
		return customerOrderDAO.updateOrderStatus(orderId, orderStatus);
	}

}

package com.fruitpay.base.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.fruitpay.base.dao.OrderPreferenceDAO;
import com.fruitpay.base.model.CustomerOrder;
import com.fruitpay.base.model.OrderPreference;

@Service
public class OrderPreferenceServiceImpl implements OrderPreferenceService {
	
	@Inject
	OrderPreferenceDAO orderPreferenceDAO;
	

	@Override
	public List<OrderPreference> findByCustomerOrder(int orderId) {
		CustomerOrder customerOrder = new CustomerOrder();
		customerOrder.setOrderId(orderId);
		return orderPreferenceDAO.findByCustomerOrder(customerOrder);
	}

}

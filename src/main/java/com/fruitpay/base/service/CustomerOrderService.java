package com.fruitpay.base.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.fruitpay.base.model.CustomerOrder;
import com.fruitpay.base.model.OrderCondition;

public interface CustomerOrderService {

	public CustomerOrder getCustomerOrder(Integer orderId);
	
	public CustomerOrder updateCustomerOrder(CustomerOrder customerOrder);
	
	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder);
	
	public Page<CustomerOrder> getAllCustomerOrder(int validFlag, int page , int size);
	
	public List<CustomerOrder> getCustomerOrdersByCustomerId(Integer customerId);
	
	public CustomerOrder getCustomerOrdersByValidFlag(Integer orderId, int validFlag);
	
	public void deleteOrder(CustomerOrder customerOrder);
	
	public void deleteOrder(List<CustomerOrder> customerOrders);
	
	public void moveToTrash(List<CustomerOrder> customerOrders);
	
	public void recover(List<CustomerOrder> customerOrders);
	
	public Page<CustomerOrder> findAllByConditions(OrderCondition orderCondition, int page , int size);
	
	public List<CustomerOrder> findAllByConditions(OrderCondition orderCondition);
	
	public CustomerOrder findOneIncludingOrderPreference(Integer orderId);

}

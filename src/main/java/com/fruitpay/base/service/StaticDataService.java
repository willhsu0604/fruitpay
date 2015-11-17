package com.fruitpay.base.service;

import java.util.List;

import com.fruitpay.base.model.OrderPlatform;
import com.fruitpay.base.model.OrderProgram;
import com.fruitpay.base.model.OrderStatus;
import com.fruitpay.base.model.PaymentMode;
import com.fruitpay.base.model.Product;
import com.fruitpay.base.model.Village;
import com.fruitpay.comm.model.SelectOption;

public interface StaticDataService {
	
	public List<Village> getAllVillages();
	
	public List<SelectOption> getAllCounties();
	
	public List<SelectOption> getTowerships(String countyCode);
	
	public List<SelectOption>  getVillages(String towershipCode);
	
	public List<Product> getAllProducts();
	
	public List<OrderPlatform> getAllOrderPlatform();
	
	public OrderPlatform getOrderPlatform(Integer platformId);
	
	public List<OrderProgram> getAllOrderProgram();
	
	public OrderProgram getOrderProgram(Integer programId);
	
	public List<OrderStatus> getAllOrderStatus();
	
	public OrderStatus getOrderStatus(Integer orderStatusId);
	
	public List<PaymentMode> getAllPaymentMode();
	
	public PaymentMode getPaymentMode(Integer paymentModeId);

}

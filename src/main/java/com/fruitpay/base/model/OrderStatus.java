package com.fruitpay.base.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OrderStatus database table.
 * 
 */
@Entity
@NamedQuery(name="OrderStatus.findAll", query="SELECT o FROM OrderStatus o")
public class OrderStatus extends AbstractDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_status_id")
	private int orderStatusId;

	@Column(name="order_status_desc")
	private String orderStatusDesc;

	@Column(name="order_status_name")
	private String orderStatusName;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="orderStatus")
	private List<CustomerOrder> customerOrders;

	public OrderStatus() {
	}

	public int getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(int orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	public String getOrderStatusDesc() {
		return this.orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}

	public String getOrderStatusName() {
		return this.orderStatusName;
	}

	public void setOrderStatusName(String orderStatusName) {
		this.orderStatusName = orderStatusName;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setOrderStatus(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setOrderStatus(null);

		return customerOrder;
	}

}
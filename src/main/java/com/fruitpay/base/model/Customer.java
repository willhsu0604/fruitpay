package com.fruitpay.base.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the Customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
@Cacheable(false)
public class Customer extends AbstractDataBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	private Integer customerId;

	private String address;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String cellphone;

	private String email;

	@Column(name="fb_id")
	private String fbId;

	@Column(name="first_name")
	private String firstName;

	private String gender;

	@Column(name="house_phone")
	private String housePhone;

	@Column(name="last_name")
	private String lastName;

	@Column(name="office_phone")
	private String officePhone;

	private String password;

	//bi-directional many-to-one association to CreditCardInfo
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<CreditCardInfo> creditCardInfos;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="referenced_id")
	@JsonBackReference
	private Customer customer;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Customer> customers;

	@ManyToOne
	@JoinColumn(name="village_code")
	private Village village;
	
	@ManyToOne
	@JoinColumn(name="towership_code")
	private Towership towership;

	//bi-directional many-to-one association to CustomerOrder
	@OneToMany(mappedBy="customer", fetch = FetchType.EAGER)
	@JsonManagedReference("customer")
	private List<CustomerOrder> customerOrders;

	public Customer() {
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFbId() {
		return this.fbId;
	}

	public void setFbId(String fbId) {
		this.fbId = fbId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getHousePhone() {
		return this.housePhone;
	}

	public void setHousePhone(String housePhone) {
		this.housePhone = housePhone;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOfficePhone() {
		return this.officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<CreditCardInfo> getCreditCardInfos() {
		return this.creditCardInfos;
	}

	public void setCreditCardInfos(List<CreditCardInfo> creditCardInfos) {
		this.creditCardInfos = creditCardInfos;
	}

	public CreditCardInfo addCreditCardInfo(CreditCardInfo creditCardInfo) {
		getCreditCardInfos().add(creditCardInfo);
		creditCardInfo.setCustomer(this);

		return creditCardInfo;
	}

	public CreditCardInfo removeCreditCardInfo(CreditCardInfo creditCardInfo) {
		getCreditCardInfos().remove(creditCardInfo);
		creditCardInfo.setCustomer(null);

		return creditCardInfo;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setCustomer(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setCustomer(null);

		return customer;
	}

	public Village getVillage() {
		return this.village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public List<CustomerOrder> getCustomerOrders() {
		return this.customerOrders;
	}

	public void setCustomerOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().add(customerOrder);
		customerOrder.setCustomer(this);

		return customerOrder;
	}

	public CustomerOrder removeCustomerOrder(CustomerOrder customerOrder) {
		getCustomerOrders().remove(customerOrder);
		customerOrder.setCustomer(null);

		return customerOrder;
	}

	public Towership getTowership() {
		return towership;
	}

	public void setTowership(Towership towership) {
		this.towership = towership;
	}

	
}
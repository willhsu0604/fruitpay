package com.fruitpay.base.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.fruitpay.base.dao.CustomerDAO;
import com.fruitpay.base.model.Customer;

@Repository("CustomerDAOImpl")
public class CustomerDAOImpl extends AbstractJPADAO<Customer> implements CustomerDAO {

	private final Logger logger = Logger.getLogger(this.getClass());
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Customer getCustomerByEmail(String email){
		
		Query q = em.createQuery("SELECT c FROM Customer c WHERE c.email = ?1");
		q.setParameter(1, email);
		try{
			return (Customer)q.getSingleResult();
		}catch(NoResultException e){
			logger.debug("the customer of email : " + email + " is not found.");;
		}
		return null;
	}

	@Override
	public boolean isEmailMatchPassword(String email, String password) {

		Query q = em.createQuery("SELECT c FROM Customer c WHERE c.email = ?1 AND c.password = ?2 ");
		q.setParameter(1, email);
		q.setParameter(2, password);
		Customer customer = null;
		try{
			customer = (Customer)q.getSingleResult();
		}catch(NoResultException e){
			logger.debug("the customer of email : " + email + " is not found.");;
		}
		
		if(customer != null){
			return true;
		}else{
			return false;
		}
	}

}

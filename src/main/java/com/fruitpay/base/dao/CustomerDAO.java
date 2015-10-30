package com.fruitpay.base.dao;

import com.fruitpay.base.model.Customer;

public interface CustomerDAO extends DAO<Customer> {
	
	/**
     * 用信箱得到顧客資訊
     *
     * @param  email
     *         信箱
     *
     * @return 顧客
     */
	public Customer getCustomerByEmail(String email);
	
	/**
	 * 用fbId得到顧客資訊
	 * 
	 * @param  fbId
     *         臉書ID
     *         
     * @return 顧客       
     *         
	 * */
	public Customer getCustomerByFbId(String fbId);
	
	/**
     * 驗證該信箱與密碼是否與資料庫資料吻合
     *
     * @param  email
     *         信箱
     * @param  password
     *         密碼
     *
     * @return 是否吻合
     */
	public boolean isEmailMatchPassword(String email, String password);
	
	/**
     * 驗證該ID與密碼是否與資料庫資料吻合
     *
     * @param  custmerId
     *         顧客ID
     * @param  password
     *         密碼
     *
     * @return 是否吻合
     */
	public boolean isCustomerIdMatchPassword(Integer custmerId, String password);
	
}

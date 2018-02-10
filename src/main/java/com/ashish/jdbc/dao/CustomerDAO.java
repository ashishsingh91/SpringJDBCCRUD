package com.ashish.jdbc.dao;

import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import com.ashish.jdbc.domain.Customer;

public interface CustomerDAO {
	
	public Customer getCustomer(Integer custid);

	public List<Customer> listCustomers();

	public void delete(Integer id);

	public void update(Integer id, String mobile);

	public void setDataSource(DataSource ds);

	void create(String cname, String mobile, Double deposit, GregorianCalendar regdate); 

}

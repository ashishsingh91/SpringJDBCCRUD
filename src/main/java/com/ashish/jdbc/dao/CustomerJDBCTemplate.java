package com.ashish.jdbc.dao;

import java.util.GregorianCalendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ashish.jdbc.domain.Customer;

public class CustomerJDBCTemplate implements CustomerDAO {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource ds) {
		this.dataSource=ds;
		this.jdbcTemplateObject=new JdbcTemplate(dataSource);
	}
	
	
	public void create(String cname, String mobile, Double deposit,	GregorianCalendar regdate) {
		String sql="insert into customer(custname,mobile,deposit,reg_date) values(?,?,?,?)";
		jdbcTemplateObject.update(sql,cname,mobile,deposit,regdate);
		System.out.println("Created Record Name=" + cname );
	}
	
	public Customer getCustomer(Integer custid) {
		String sql="select * from customer where custid=?";
		Customer customer=jdbcTemplateObject.queryForObject(sql,new Object[]{custid},new CustomerMapper());
		return customer;
	}
	

	public List<Customer> listCustomers() {
		String sql="select * from customer";
		List<Customer> customers=jdbcTemplateObject.query(sql,new CustomerMapper());
		return customers;
	}
	public void delete(Integer id) {
		String sql="delete from customer where custid=?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record " + id + " Deleted successfully");
	}

	public void update(Integer id, String mobile) {
		String sql="update customer set mobile=? where custid=?";
		jdbcTemplateObject.update(sql, mobile,id);
		System.out.println("Record " + id + " Updated successfully");
	}


}

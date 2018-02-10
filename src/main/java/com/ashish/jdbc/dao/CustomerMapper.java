package com.ashish.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ashish.jdbc.domain.Customer;

public class CustomerMapper implements  RowMapper<Customer>  {

	public Customer mapRow(ResultSet rs, int rownum) throws SQLException {
		Customer cust=new Customer();
		cust.setCustid(rs.getInt("custid"));
		cust.setCustname(rs.getString("custname"));
		cust.setMobile(rs.getString("mobile"));
		cust.setDeposit(rs.getDouble("deposit"));
		cust.setReg_date(rs.getDate("reg_date"));
		return cust;
	}

}

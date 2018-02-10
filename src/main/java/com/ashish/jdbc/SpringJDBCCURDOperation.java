package com.ashish.jdbc;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ashish.jdbc.dao.CustomerJDBCTemplate;
import com.ashish.jdbc.domain.Customer;

public class SpringJDBCCURDOperation {

	public static void main(String[] args) {
		ApplicationContext context=new  ClassPathXmlApplicationContext("Beans.xml");
		CustomerJDBCTemplate custjdbctemp=(CustomerJDBCTemplate)context.getBean("jdbctemp");
		int choice=0;
		do{
			System.out.println("Menu\n1.Insert Record\n2.Find\n3.ListAll \n4.Update \n5.Delete \n6.Exit");
			System.out.println("Enter Your Choice(1to4):");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					System.out.println("\nEnter Name:");
					String cname=sc.next();
					System.out.println("\nEnter Mobile:");
					String mobile=sc.next();
					System.out.println("\nEnter Deposit Amount:");
					Double amt=sc.nextDouble();
					System.out.println("\nEnter RegistrationDate");
					System.out.println("\nEnter Date:");
					int date=sc.nextInt();
					System.out.println("\nEnter Month(0-11):");
					int month=sc.nextInt();
					System.out.println("\nEnter Year:");
					int year=sc.nextInt();
					GregorianCalendar regdate=new
					GregorianCalendar(year, month, date);
					custjdbctemp.create(cname,mobile,amt,regdate);
					break;
				case 2:
					System.out.println("\nEnter Customer ID to Search:");
					int custid=sc.nextInt();
					Customer cust=custjdbctemp.getCustomer(custid);
					System.out.println("Customer Details\n"+cust);
					break;
				case 3:
					List<Customer> clist=custjdbctemp.listCustomers();
					for(Customer customer :clist)
					{
						System.out.println(customer);
					}
					break;
				case 4:
					System.out.println("\nEnter Customer ID to Update:");
					int cust_id=sc.nextInt();
					System.out.println("\nEnter new Mobile number to upadate");
					String new_mobile=sc.next();
					custjdbctemp.update(cust_id, new_mobile);
					break;
				case 5:
					System.out.println("\nEnter Customer ID to Delete:");
					int del_cust_id=sc.nextInt();
					custjdbctemp.delete(del_cust_id);
					break;
				case 6:
					System.exit(0);
					default:
					System.out.println("Invalid Choice");
			}
			
		}while(choice>0);


	}

}

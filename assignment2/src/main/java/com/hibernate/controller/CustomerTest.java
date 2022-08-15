package com.hibernate.controller;

import java.util.Date;

import com.hibernate.DAO.CustomerDAO;
import com.hibernate.DAO.CustomerDAOImpl;
import com.hibernate.model.Customer;
import com.hibernate.model.Locker;

public class CustomerTest {

	private static CustomerDAO dao = new CustomerDAOImpl();
	
	public static void main(String[] args) throws Exception {
//		insert();
		read();
	}


	private static void read() {
		Customer customer = dao.getByCustomerId(1);
		System.out.println(customer);
	}

	private static void insert() throws Exception {
		Locker locker = new Locker("LOC101", "small", 1000);
		Customer customer = new Customer("7001", "William", new Date(), "Kolkat", 906770981, locker);
		System.out.println(dao.saveOrUpdate(customer));
	}


}

package com.hibernate.DAO;

import com.hibernate.model.Customer;
import com.hibernate.model.Locker;

public interface CustomerDAO {

	String saveOrUpdate(Object movie) throws Exception;

	void delete(Class<? extends Object> object, Integer id);

	Locker getById(Integer id);
	Customer getByCustomerId(Integer id);
}

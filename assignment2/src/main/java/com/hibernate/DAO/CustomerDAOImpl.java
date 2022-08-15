package com.hibernate.DAO;

import java.util.Objects;
import java.util.concurrent.locks.Lock;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Customer;
import com.hibernate.model.Locker;
import com.hibernate.util.HibernateUtil;

public  class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public CustomerDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public String saveOrUpdate(Object movie) throws Exception {
		try {
			session.saveOrUpdate(movie);
			session.getTransaction().commit();
		}catch (Exception e) {
			throw new Exception("Data is not saved");
		}
		return "Data saved/Updated susccessfully";
	}

	public void delete(Class<? extends Object> object, Integer id) {
		if("Locker".equals(object.getSimpleName())) {
			Locker locker = getById(id);
			if(!Objects.isNull(locker)) {
				session.remove(locker);
				session.getTransaction().commit();
			}
		}else {
			Customer customer = getByCustomerId(id);
			if(!Objects.isNull(customer)) {
				session.remove(customer);
				session.getTransaction().commit();
			}
		}
	}

	public Customer getByCustomerId(Integer id) {
		return session.get(Customer.class, id);
	}

	public Locker getById(Integer id) {
		return session.get(Locker.class, id);
	}

}

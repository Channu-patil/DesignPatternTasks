package com.hibernate.controller;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Asset;
import com.hibernate.model.Employee;
import com.hibernate.util.HibernateUtil;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		insert(session);
//		read(session);
//		update(session);
//		delete(session);
//		aggregateFunc(session);
		session.close();
	}
	
	private static void aggregateFunc(Session session) {
		//Max
		Query query = session.createQuery("SELECT MAX(revenueInDollars) FROM Movie");
		System.out.println(query.list());
		
		//Min
		Query query1 = session.createQuery("SELECT MIN(revenueInDollars) FROM Movie");
		System.out.println(query1.list());
		
		//Sum
		Query query2 = session.createQuery("SELECT SUM(revenueInDollars) FROM Movie");
		System.out.println(query2.list());
		
		//AVG
		Query query3 = session.createQuery("SELECT AVG(revenueInDollars) FROM Movie");
		System.out.println(query3.list());
		
		//COUNT
		String language = "Kannada";
		Query query4 = session.createQuery("SELECT COUNT(*) FROM Movie where language=:lang");
		query4.setString("lang", language);
		System.out.println(query4.list());
		
		//Group By
		Query query5 = session.createQuery("SELECT COUNT(*) FROM Movie m GROUP BY m.language");
		System.out.println(query5.list());
	}


	private static void delete(Session session) {
		Employee employee = session.get(Employee.class, 1);
		session.remove(employee);
		session.getTransaction().commit();
	}

	private static void update(Session session) {
		Employee employee = session.get(Employee.class, 1);
		employee.setPassword("Abhay_123");
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
	}

	private static void read(Session session) {
		Asset asset = session.get(Asset.class, 1);
		System.out.println(asset);
		Asset asset2 = session.load(Asset.class, 1);
		System.out.println(asset2);
		
		//Max
		Query query2 = session.createQuery("SELECT MAX(assrtPrice) FROM Asset");
		System.out.println(query2.list());
		
		//Order By
		Query query3 = session.createQuery("FROM Employee e Order By e.empId ASC");
		System.out.println(query3.list());
		
		//Average
		Query query4 = session.createQuery("SELECT AVG(assrtPrice) FROM Asset");
		System.out.println(query4.list());
		
		//Count
		Query query = session.createQuery("SELECT COUNT(*) FROM Employee");
		System.out.println(query.list());
		
	}

	private static void insert(Session session) {
		Asset asset = new Asset(101, 897609, 564324, "Laptop", 8950, "Bengaluru");
		Employee employee = new Employee("Ajay", 101, "Ajay@123", asset);
		session.saveOrUpdate(employee);
		session.getTransaction().commit();
	}
}

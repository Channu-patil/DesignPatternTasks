package com.hibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import com.hibernate.model.Hollywood;
import com.hibernate.model.Movie;
import com.hibernate.util.HibernateUtil;

@SuppressWarnings({ "rawtypes", "deprecation" })
public class MainClass {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	
//		System.out.println(hqlQuery1(session));
//		hqlQuery2(session);
//		hqlQuery3(session);
//		hqlQuery4(session);
//		hqlQuery5(session);
//		hqlQuery6(session);
//		hqlQuery7(session);
	}

	private static void hqlQuery7(Session session) {
		Query query = session.createQuery("select m.movieName, m.director.directorName from Movie m");
		List<Object[]> list = query.list();
		for(Object[] string : list) {
			System.out.println("Movie Name : "+string[0]);
			System.out.println("Director Name : "+string[1]);
		}
	}

	private static void hqlQuery6(Session session) {
		Criteria criteria = session.createCriteria( Movie.class );
		criteria.setProjection( Projections.distinct( Projections.property( "language" ) ) );
		System.out.println(criteria.list());
	}

	private static void hqlQuery5(Session session) {
		Movie movie = hqlQuery1(session).get(0);
		session.remove(movie);
		session.getTransaction().commit();
	}

	private static void hqlQuery4(Session session) {
		Movie movie = hqlQuery1(session).get(0);
		movie.setRevenueInDollars(movie.getRevenueInDollars()+10000);
		session.saveOrUpdate(movie);
		session.getTransaction().commit();
	}

	private static List<Movie> hqlQuery1(Session session) {
		String language = "English";
		Query query = session.createQuery("from Movie m where m.language =:lang");
		query.setString("lang", language);
		List<Movie> list = query.list();
		return list.isEmpty()?new ArrayList<Movie>():list;
	}

	private static void hqlQuery2(Session session) {
		String director = "prashant Neel";
		Query query = session.createQuery("from Movie m where m.director.directorName=:dir");
		query.setString("dir", director);
		List list = query.list();
		System.out.println(list);
	}
	
	private static void hqlQuery3(Session session) {
		for(Movie x : hqlQuery1(session)) {
			Hollywood hollywood = new Hollywood(x.getMovieId(), x.getMovieName(), x.getLanguage(), x.getReleasedIn(), x.getRevenueInDollars());
			session.saveOrUpdate(hollywood);
			session.getTransaction().commit();
		}
	}
}

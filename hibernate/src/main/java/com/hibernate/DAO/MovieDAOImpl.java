package com.hibernate.DAO;

import java.util.Objects;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.model.Movie;
import com.hibernate.util.HibernateUtil;

public class MovieDAOImpl implements MovieDAO {

	private SessionFactory sessionFactory;
	private Session session;

	public MovieDAOImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public String addMovie(Movie movie) throws Exception {
		try {
			session.save(movie);
			session.getTransaction().commit();
		} catch (Exception e) {
			throw new Exception("Data is not inserted in Database");
		}
		return "Data Saved Successfully";
	}

	public void deleteMovie(Integer id) {
		Movie movie = getMovieDetails(id);
		if (!Objects.isNull(movie)) {
			session.remove(movie);
			session.getTransaction().commit();
		}
	}

	public void updateMovie(Movie movie) {
		session.update(movie);
		session.getTransaction().commit();
	}

	public Movie getMovieDetails(Integer id) {
		return session.get(Movie.class, id);
	}

}

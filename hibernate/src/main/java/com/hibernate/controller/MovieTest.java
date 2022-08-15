package com.hibernate.controller;

import java.util.Objects;

import com.hibernate.DAO.MovieDAO;
import com.hibernate.DAO.MovieDAOImpl;
import com.hibernate.model.Movie;

public class MovieTest {

	private static MovieDAO dao = new MovieDAOImpl();
	
	public static void main(String[] args) throws Exception {
//		insert();
//		read();
//		update();
		delete();
	}

	private static void delete() {
		dao.deleteMovie(1);
	}

	private static void update() {
		Movie movie = dao.getMovieDetails(1);
		if(!Objects.isNull(movie)) {
			movie.setRevenueInDollars(movie.getRevenueInDollars()+10000);
			dao.updateMovie(movie);
			System.out.println("Successfully updated the data");
		}else System.out.println("Data is not updated");
		
	}

	private static void read() {
		Movie movie = dao.getMovieDetails(1);
		System.out.println(movie);
	}

	private static void insert() throws Exception {
		Movie movie = new Movie("MOVIE-001", "KGF", "KANNADA", 2022, 75000);
		System.out.println(dao.addMovie(movie));
	}

}

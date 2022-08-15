package com.hibernate.DAO;

import com.hibernate.model.Movie;

public interface MovieDAO {

	String addMovie(Movie movie) throws Exception;

	void deleteMovie(Integer id);

	void updateMovie(Movie movie);

	Movie getMovieDetails(Integer id);
}

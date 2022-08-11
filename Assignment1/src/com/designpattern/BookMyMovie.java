package com.designpattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BookMyMovie {
	private int movieId;
	private int noOfTickets;
	private double discount;
	private double totalAmount;

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private static final Map<Integer, Integer> map = new HashMap() {
		{
			put(101, 120);
			put(102, 170);
			put(103, 150);
		}
	};

	public BookMyMovie(int movieId, int noOfTickets) throws Exception {
		if(Objects.isNull(map.get(movieId))) 
			throw new Exception("1. Sorry Invalid Movie ID  \n 2.Please CHeck the Movie ID and enter once again");
		
		if(noOfTickets < 1 || noOfTickets > 15) throw new Exception("No of Ticketes per booking is minimum 1 and maximum 15");
		this.movieId = movieId;
		this.noOfTickets = noOfTickets;
		calculateDiscount();
		this.totalAmount = calculateTicketAmount();

	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public void calculateDiscount() {
		if ((this.movieId == 101 || this.movieId == 102 || this.movieId == 103) && this.noOfTickets < 5)
			this.discount = 0.0;
		else if ((this.movieId == 101 || this.movieId == 103) && (this.noOfTickets >= 5 && this.noOfTickets < 10))
			this.discount = 15.0;
		else if ((this.movieId == 101 || this.movieId == 103) && (this.noOfTickets >= 10 && this.noOfTickets < 15))
			this.discount = 20.0;
		else if (this.movieId == 102 && (this.noOfTickets >= 5 && this.noOfTickets < 10))
			this.discount = 10.0;
		else if (this.movieId == 102 && (this.noOfTickets >= 10 && this.noOfTickets < 15))
			this.discount = 15.0;
	}

	public double calculateTicketAmount() {
		return map.get(this.movieId) * this.noOfTickets - (map.get(this.movieId) * this.noOfTickets * (this.discount/100));
	}
}

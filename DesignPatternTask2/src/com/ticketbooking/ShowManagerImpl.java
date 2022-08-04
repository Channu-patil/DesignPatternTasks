package com.ticketbooking;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;

public class ShowManagerImpl implements ShowManager {

	public static volatile List<Show> shows = populateShows();

	@Override
	public void populate(Show show) {
		shows.add(show);
	}

	@Override
	public void bookShow(List<Show> showList, String showName, String show_time, int noOfSeats)
			throws UnknownShowException, SeatsNotAvailableException, InvalidSeatNumberException {
		boolean flag = true;
		for (Show show : shows) {
			if (show.getShowName().equalsIgnoreCase(showName) && show.getShowTime().equals(show_time)
					&& show.getSeatsAvailable() >= noOfSeats) {
				show.setSeatsAvailable(show.getSeatsAvailable() - noOfSeats);
				flag = false;
				break;
			} 
		}
		if(flag) {
			for(Show show:shows) {
				if (!show.getShowName().equalsIgnoreCase(showName)) {
					throw new UnknownShowException("The Show named " + showName + " is not available");
				} else if (show.getShowTime().equals(show_time)) {
					throw new UnknownShowException(
							"The Show named " + showName + " is not available at the time " + show_time);
				} else if (show.getSeatsAvailable() >= noOfSeats) {
					throw new SeatsNotAvailableException(
							"Currently the seats is almost booked, Sorry fot the incovinience");
				}
			}
		}
	}

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	private static List<Show> populateShows() {
		return new LinkedList() {
			{
				add(new Show("VikrantRona", LocalTime.of(9, 30, 0).toString(), 50));
				add(new Show("KGF2", LocalTime.of(12, 45, 0).toString(), 42));
				add(new Show("RRR", LocalTime.of(11, 00, 0).toString(), 35));
				add(new Show("VikrantRona", LocalTime.of(12, 45, 0).toString(), 30));
				add(new Show("VikrantRona", LocalTime.of(15, 00, 0).toString(), 50));
				add(new Show("VikrantRona", LocalTime.of(19, 30, 0).toString(), 113));
				add(new Show("VikrantRona", LocalTime.of(22, 50, 0).toString(), 65));
				add(new Show("KGF2", LocalTime.of(12, 30, 0).toString(), 50));
				add(new Show("KGF2", LocalTime.of(16, 45, 0).toString(), 70));
				add(new Show("KGF2", LocalTime.of(20, 30, 0).toString(), 40));
				add(new Show("KGF2", LocalTime.of(23, 00, 0).toString(), 45));
				add(new Show("RRR", LocalTime.of(7, 30, 0).toString(), 120));
				add(new Show("RRR", LocalTime.of(13, 30, 0).toString(), 25));
				add(new Show("RRR", LocalTime.of(17, 40, 0).toString(), 100));
			}
		};
	}
}

package com.ticketbooking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;

public class BookMyShow {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {

		List<Show> list = ShowManagerImpl.shows;
		ShowManagerImpl dmi = new ShowManagerImpl();

        String fileName = "C:\\Users\\ChennabasavanagoudaP\\java8\\DesignPatternTask2\\resources\\show.txt";
		BufferedReader inputReader =new BufferedReader (new InputStreamReader(new FileInputStream(fileName)));
        String showName = inputReader.readLine().split("=")[1];
        String showTime = inputReader.readLine().split("=")[1];
        String seatsAvailable = inputReader.readLine().split("=")[1];
        dmi.populate(new Show(showName, showTime, Integer.parseInt(seatsAvailable)));
		
		list = new ShowImpl().displayAllShows();
		list.stream().sorted(Comparator.comparing(Show::getShowName)).forEach(x -> System.out.println(x));

		try {
			dmi.bookShow(list, "KGF2", "24:45", 42);
			list = ShowManagerImpl.shows;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}

package com.java.solidprinciples;

import java.util.Comparator;
import java.util.stream.Collectors;

public class CandidateStreamingOperations {
	public static void main(String[] args) {

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates: ");
		InterviewRepository.getCandidateList().stream().filter(cty -> "Pune".equalsIgnoreCase(cty.getCity()))
				.forEach(x -> System.out.println(x));
		printLine();
		
		// list city and count of candidates per city
		System.out.println("Candidate count per city");
		InterviewRepository.getCandidateList().stream().collect(Collectors.groupingBy(cty -> cty.getCity()))
				.forEach((k, v) -> System.out.println("City : " + k + " ,No of Candidates : " + v.size()));
		printLine();
		
		// list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		InterviewRepository.getCandidateList().stream()
				.collect(Collectors.groupingBy(cty -> cty.getTechnicalExpertise())).forEach((k, v) -> System.out
						.println("Technical Expertise : " + k + " ,No of Candidates : " + v.size()));
		printLine();
		
		// list fresher candidates
		System.out.println("Fresher Candidate list");
		InterviewRepository.getCandidateList().stream().filter(cn -> cn.getYearsOfExperience() <= 1)
				.forEach(x -> System.out.println(x));
		printLine();
		
		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience");
		InterviewRepository.getCandidateList().stream().sorted(Comparator.comparing(Candidate::getYearsOfExperience))
				.forEach(x -> System.out.println(x));
		printLine();
		
		// sort the candidates by city name
		System.out.println("Sorted List of Candidates by City Name");
		InterviewRepository.getCandidateList().stream().sorted(Comparator.comparing(Candidate::getCity))
				.forEach(x -> System.out.println(x));
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}

}

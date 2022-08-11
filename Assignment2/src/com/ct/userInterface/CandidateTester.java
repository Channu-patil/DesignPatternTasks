package com.ct.userInterface;

import java.util.List;

import com.ct.model.CandidateReport;
import com.ct.service.CandidateService;
import com.ct.service.CandidateServiceImpl;

public class CandidateTester {

	private static CandidateService candidateService = new CandidateServiceImpl();

	public static void main(String[] args) throws Exception {
		CandidateReport candidateReport =  new CandidateReport(12346, "Sam", 51, 56, 78, 'P', "ECE");
		System.out.println(candidateService.addCandidate(candidateReport));
		
		List<CandidateReport> report = candidateService.getGradesForAllCandidates();
		for(CandidateReport report2 : report) {
			System.out.println("CandidateID \t Result");
			System.out.println(report2.getCandidateId() +"\t\t "+ candidateService.calculateGrade(report2));
		}
	}
}

package com.ct.service;

import java.util.List;

import com.ct.model.CandidateReport;

public interface CandidateService {

	String calculateGrade(CandidateReport candidateReport);
	List<CandidateReport> getGradesForAllCandidates();
	String addCandidate(CandidateReport candidate) throws Exception;
}

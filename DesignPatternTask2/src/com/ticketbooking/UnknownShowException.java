package com.ticketbooking;

public class UnknownShowException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2742516222481048812L;
	public UnknownShowException(String exceptionMessage) {
		super(exceptionMessage);
	}
}

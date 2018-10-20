package com.cg.sms.exception;

public class StudentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7371122004862097142L;

	public StudentException(String message) {
		// TODO Auto-generated constructor stub
		System.err.println(message);
	}
}

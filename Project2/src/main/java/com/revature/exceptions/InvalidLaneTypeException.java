package com.revature.exceptions;

public class InvalidLaneTypeException extends Exception {
	public InvalidLaneTypeException() {
		System.err.println("This is not a lane type");
	}
}

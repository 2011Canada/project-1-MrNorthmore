package com.revature.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends AbstractHttpException {

	public UserNotFoundException() {
		super("User not found", 404);
	}

}

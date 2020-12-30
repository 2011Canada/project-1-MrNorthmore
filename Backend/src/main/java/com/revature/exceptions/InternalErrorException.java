package com.revature.exceptions;

@SuppressWarnings("serial")
public class InternalErrorException extends AbstractHttpException {
	public InternalErrorException() {
		super("OOPS, something went wrong", 500);
	}
}

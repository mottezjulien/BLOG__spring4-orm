package fr.jmottez.lessons.spring.spring4.infrastructure.exception;

public class ServiceException extends Exception {

	public ServiceException(Throwable cause) {
		super(cause);
	}

}
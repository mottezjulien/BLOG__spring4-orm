package fr.jmottez.lessons.spring.spring4.infrastructure.exception;

public class RepositoryException extends RuntimeException {

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}

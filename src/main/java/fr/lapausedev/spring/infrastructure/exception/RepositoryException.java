package fr.lapausedev.spring.infrastructure.exception;

public class RepositoryException extends RuntimeException {

	public RepositoryException(String message, Throwable cause) {
		super(message, cause);
	}

}

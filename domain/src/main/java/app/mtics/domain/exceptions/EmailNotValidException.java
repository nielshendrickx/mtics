package app.mtics.domain.exceptions;

public class EmailNotValidException extends RuntimeException {
    public EmailNotValidException(String email) {
        super("The provided email '" + email + "' is not valid.");
    }
}
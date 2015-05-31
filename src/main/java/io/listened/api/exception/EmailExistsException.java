package io.listened.api.exception;

/**
 * Created by Clay on 5/29/2015.
 */
public class EmailExistsException extends RuntimeException {
    public EmailExistsException(String email) {
        super(String.format("'%s' is already in use", email));
    }
}
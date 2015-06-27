package io.listened.api.exception;

/**
 * Created by Clay on 6/25/2015.
 */
public class FeedExistsException extends RuntimeException {
    public FeedExistsException(String feedUrl) {
        super(String.format("The feed already exists: %s", feedUrl));
    }
}

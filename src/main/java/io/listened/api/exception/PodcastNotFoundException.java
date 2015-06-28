package io.listened.api.exception;

/**
 * Created by Clay on 6/27/2015.
 * Exception class for use when podcast cannot be located by podcast id
 */
public class PodcastNotFoundException extends RuntimeException {
    public PodcastNotFoundException(Long podcastId) {
        super("Unable to find podcast id: "+podcastId);
    }
}

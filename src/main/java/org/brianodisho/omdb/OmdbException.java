package org.brianodisho.omdb;

/**
 * Created by brianodisho on 8/26/16.
 */
public class OmdbException extends Exception {

    public OmdbException() {
    }

    public OmdbException(String message) {
        super(message);
    }

    public OmdbException(String message, Throwable cause) {
        super(message, cause);
    }

    public OmdbException(Throwable cause) {
        super(cause);
    }

    public OmdbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

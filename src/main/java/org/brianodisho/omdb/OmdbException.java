package org.brianodisho.omdb;

import java.io.IOException;

/**
 * Created by brianodisho on 9/7/16.
 */
public class OmdbException extends Exception {

    public OmdbException() {
        super();
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


    protected OmdbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}

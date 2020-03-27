package com.blissofgiving.exception;

public class BlissofgivingCheckedException extends Exception {

    public BlissofgivingCheckedException() {
        super();
    }

    public BlissofgivingCheckedException(String message) {
        super(message);
    }

    public BlissofgivingCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlissofgivingCheckedException(Throwable cause) {
        super(cause);
    }

    protected BlissofgivingCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

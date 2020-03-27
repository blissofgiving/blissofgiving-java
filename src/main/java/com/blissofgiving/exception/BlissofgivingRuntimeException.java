package com.blissofgiving.exception;

public class BlissofgivingRuntimeException extends RuntimeException {
    public BlissofgivingRuntimeException() {
        super();
    }

    public BlissofgivingRuntimeException(String message) {
        super(message);
    }

    public BlissofgivingRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlissofgivingRuntimeException(Throwable cause) {
        super(cause);
    }

    protected BlissofgivingRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

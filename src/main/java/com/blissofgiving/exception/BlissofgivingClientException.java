package com.blissofgiving.exception;

public class BlissofgivingClientException extends BlissofgivingRuntimeException {
    public BlissofgivingClientException() {
        super();
    }

    public BlissofgivingClientException(String message) {
        super(message);
    }

    public BlissofgivingClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlissofgivingClientException(Throwable cause) {
        super(cause);
    }

    protected BlissofgivingClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

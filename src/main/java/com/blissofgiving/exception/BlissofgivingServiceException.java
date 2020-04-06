package com.blissofgiving.exception;

public class BlissofgivingServiceException extends BlissofgivingRuntimeException {
    public BlissofgivingServiceException() {
        super();
    }

    public BlissofgivingServiceException(String message) {
        super(message);
    }

    public BlissofgivingServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlissofgivingServiceException(Throwable cause) {
        super(cause);
    }

    protected BlissofgivingServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

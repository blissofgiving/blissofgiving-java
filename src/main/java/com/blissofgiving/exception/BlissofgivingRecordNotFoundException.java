package com.blissofgiving.exception;

public class BlissofgivingRecordNotFoundException extends BlissofgivingCheckedException {
    public BlissofgivingRecordNotFoundException() {
        super();
    }

    public BlissofgivingRecordNotFoundException(String message) {
        super(message);
    }

    public BlissofgivingRecordNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlissofgivingRecordNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BlissofgivingRecordNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

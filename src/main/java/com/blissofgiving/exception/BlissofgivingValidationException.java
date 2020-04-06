package com.blissofgiving.exception;

import java.util.ArrayList;

public class BlissofgivingValidationException extends BlissofgivingCheckedException {

    private BlissofgivingValidationResult blissofgivingValidationResult;

    public BlissofgivingValidationResult getBlissofgivingValidationResult() {
        return blissofgivingValidationResult;
    }

    public void setBlissofgivingValidationResult(BlissofgivingValidationResult blissofgivingValidationResult) {
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }

    public BlissofgivingValidationException(BlissofgivingValidationResult blissofgivingValidationResult) {
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }

    public BlissofgivingValidationException(String message, BlissofgivingValidationResult blissofgivingValidationResult) {
        super(message);
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }

    public BlissofgivingValidationException(String message, Throwable cause, BlissofgivingValidationResult blissofgivingValidationResult) {
        super(message, cause);
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }

    public BlissofgivingValidationException(Throwable cause, BlissofgivingValidationResult blissofgivingValidationResult) {
        super(cause);
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }

    public BlissofgivingValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BlissofgivingValidationResult blissofgivingValidationResult) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.blissofgivingValidationResult = blissofgivingValidationResult;
    }
}

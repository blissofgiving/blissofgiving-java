package com.blissofgiving.exception;

import java.io.Serializable;
import java.util.ArrayList;

public class BlissofgivingValidationResult implements Serializable {

    private ArrayList<BlissofgivingValidationError> warnings;
    private ArrayList<BlissofgivingValidationError> errors;

    public ArrayList<BlissofgivingValidationError> getWarnings() {
        return warnings;
    }

    public void setWarnings(ArrayList<BlissofgivingValidationError> warnings) {
        this.warnings = warnings;
    }

    public ArrayList<BlissofgivingValidationError> getErrors() {
        return errors;
    }

    public void setErrors(ArrayList<BlissofgivingValidationError> errors) {
        this.errors = errors;
    }
}

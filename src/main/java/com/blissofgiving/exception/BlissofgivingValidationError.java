package com.blissofgiving.exception;

import java.io.Serializable;
import java.util.ArrayList;

public class BlissofgivingValidationError implements Serializable {

    private String fieldID;
    private String messageKey;
    private String messageLabel;
    private ArrayList<Object> messageLabelParams;

    public BlissofgivingValidationError(String fieldID, String messageKey, String messageLabel, ArrayList<Object> messageLabelParams) {
        this.fieldID = fieldID;
        this.messageKey = messageKey;
        this.messageLabel = messageLabel;
        this.messageLabelParams = messageLabelParams;
    }

    public String getFieldID() {
        return fieldID;
    }

    public void setFieldID(String fieldID) {
        this.fieldID = fieldID;
    }

    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }

    public String getMessageLabel() {
        return messageLabel;
    }

    public void setMessageLabel(String messageLabel) {
        this.messageLabel = messageLabel;
    }

    public ArrayList<Object> getMessageLabelParams() {
        return messageLabelParams;
    }

    public void setMessageLabelParams(ArrayList<Object> messageLabelParams) {
        this.messageLabelParams = messageLabelParams;
    }
}

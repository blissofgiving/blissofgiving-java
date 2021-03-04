package com.blissofgiving.service.validator;

import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.dynamodbmodel.User;

public interface UserServiceValidator {

    void validateUser(User user) throws BlissofgivingValidationException;

}

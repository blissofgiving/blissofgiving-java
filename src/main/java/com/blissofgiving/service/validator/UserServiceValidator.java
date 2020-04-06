package com.blissofgiving.service.validator;

import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.model.User;

public interface UserServiceValidator {

    void validateUser(User user) throws BlissofgivingValidationException;

}

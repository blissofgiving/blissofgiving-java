package com.blissofgiving.service.validator;

import com.blissofgiving.exception.BlissofgivingServiceException;
import com.blissofgiving.exception.BlissofgivingValidationError;
import com.blissofgiving.exception.BlissofgivingValidationException;
import com.blissofgiving.exception.BlissofgivingValidationResult;
import com.blissofgiving.dynamodbmodel.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceValidatorImpl implements UserServiceValidator {

    @Override
    public void validateUser(User user) throws BlissofgivingValidationException {
        if(user == null){
            throw new BlissofgivingServiceException("User object is null.");
        }
        //validate required fields
        ArrayList<BlissofgivingValidationError> errors = new ArrayList<>();

        if(user.getUserId() == null || user.getUserId().length() <= 0){
            BlissofgivingValidationError validationResult = new BlissofgivingValidationError("username", "label.username.empty",
                    "UserId is empty", null);
            errors.add(validationResult);
        }

        if(user.getPassword() == null || user.getPassword().length() <= 0){
            BlissofgivingValidationError validationResult = new BlissofgivingValidationError("password", "label.password.empty",
                    "Password is empty", null);
            errors.add(validationResult);
        }

        //TODO Shashi validate from DB

        if(errors.size() > 0){
            BlissofgivingValidationResult result = new BlissofgivingValidationResult();
            result.setErrors(errors);
            throw new BlissofgivingValidationException(result);
        }



    }
}

package by.ps.useraccountapp.application.util;

import by.ps.useraccountapp.exception.ValidationException;

import java.util.Set;

public class UserInputValidator implements Validator {

    @Override
    public boolean validateString(String value, String pattern, String error) throws ValidationException {

        if (!value.matches(pattern)) {
            throw new ValidationException(error);
        }

        return true;
    }

    @Override
    public boolean validateSet(Set<String> values, String pattern) throws ValidationException {

        if ((values.size() >= 1) & (values.size() <= 3)) {
            return true;
        } else {
            throw new ValidationException("Number of values must be from 1 to 3");
        }
    }
}

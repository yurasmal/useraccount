package by.ps.useraccountapp.application.util;

import by.ps.useraccountapp.exception.ValidationException;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserInputValidator implements Validator {

    private static final String EMAIL_PATTERN = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

    private static final String PHONE_NUMBER_PATTERN = "^(375)?\\d{2}\\s\\d{7}";

    @Override
    public boolean isSetSizeValid(Set<String> values) throws ValidationException {

        if ((values.size() >= 1) & (values.size() <= 3)) {
            return true;
        } else {
            throw new ValidationException("Number of values must be from 1 to 3");
        }
    }

    @Override
    public boolean isPhoneNumberValid(String phoneNumber) throws ValidationException {

        if (!phoneNumber.matches(PHONE_NUMBER_PATTERN)) {
            throw new ValidationException("Phone number must be in format '375** *******' ");
        }

        return true;
    }

    @Override
    public boolean isEmailValid(String email) throws ValidationException {

        Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new ValidationException("Email must be in format 'any@email.com' case insensitive");
        }

        return true;
    }
}

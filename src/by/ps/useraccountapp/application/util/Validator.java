package by.ps.useraccountapp.application.util;

import by.ps.useraccountapp.exception.ValidationException;

import java.util.Set;

public interface Validator {

    boolean validateString(String value, String pattern, String error) throws ValidationException;

    boolean validateSet(Set<String> values, String pattern) throws ValidationException;
}

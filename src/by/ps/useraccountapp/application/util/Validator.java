package by.ps.useraccountapp.application.util;

import by.ps.useraccountapp.exception.ValidationException;

import java.util.Set;

public interface Validator {

    boolean isSetSizeValid(Set<String> values) throws ValidationException;

    boolean isPhoneNumberValid(String phoneNumber) throws ValidationException;

    boolean isEmailValid(String email) throws ValidationException;
}

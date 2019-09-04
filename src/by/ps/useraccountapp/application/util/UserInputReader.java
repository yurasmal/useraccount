package by.ps.useraccountapp.application.util;

import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.exception.ValidationException;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputReader {

    private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");

    private static Validator validator = AppConfig.getValidator();

    public static int getInt() {

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }

        System.out.println("Enter integer value, please");
        scanner.next();

        return getInt();
    }

    public static String getValidString(String pattern, String errorMessage) {

        String value = scanner.next();

        try {
            if (validator.validateString(value, pattern, errorMessage)) {
                return value;
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        return getValidString(pattern, errorMessage);
    }

    public static Set<String> getValidSet(String pattern, String errorMessage) {

        Set<String> values = new HashSet<>();

        while (true) {

            if (exitCondition()) {
                break;
            }

            String validValue = getValidString(pattern, errorMessage);
            values.add(validValue);
        }

        try {
            if (validator.validateSet(values, pattern)) {
                return values;
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
        }

        return getValidSet(pattern, errorMessage);
    }

    private static boolean exitCondition() {

        if (scanner.hasNextInt()) {
            if (scanner.nextInt() == 0) {
                return true;
            }
        }

        return false;
    }
}

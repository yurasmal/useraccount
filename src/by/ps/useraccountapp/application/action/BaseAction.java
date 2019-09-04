package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.application.util.UserInputReader;
import by.ps.useraccountapp.service.UserService;

import java.util.Properties;
import java.util.Set;

public class BaseAction {

    protected static Properties properties = AppConfig.getProperties();

    protected UserService userService = AppConfig.getUserService();

    protected final String EMAIL_PATTERN = properties.getProperty("pattern.email");
    protected final String PHONE_NUMBER_PATTERN = properties.getProperty("pattern.phone");
    protected final String ALL_PATTERN = properties.getProperty("pattern.all");
    protected final String EMAIL_ERROR = properties.getProperty("email.error");
    protected final String PHONE_ERROR = properties.getProperty("phone.error");

    protected int getIntegerValue(String message) {
        System.out.println(message);
        return UserInputReader.getInt();
    }

    protected String getValidString(String message, String pattern, String errorMessage) {
        System.out.println(message);
        return UserInputReader.getValidString(pattern, errorMessage);
    }

    protected Set<String> getValidSet(String message, String pattern, String errorMessage) {
        System.out.println(message);
        return UserInputReader.getValidSet(pattern, errorMessage);
    }
}

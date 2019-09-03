package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.application.util.UserInputReader;
import by.ps.useraccountapp.service.UserService;

import java.util.Properties;
import java.util.Set;

public class BaseAction {

    protected UserService userService = AppConfig.getUserService();

    protected static Properties properties = AppConfig.getProperties();

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

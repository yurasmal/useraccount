package by.ps.useraccountapp.application.config;

import by.ps.useraccountapp.application.action.*;
import by.ps.useraccountapp.application.util.UserInputValidator;
import by.ps.useraccountapp.application.util.Validator;
import by.ps.useraccountapp.repository.FileUserRepository;
import by.ps.useraccountapp.repository.UserRepository;
import by.ps.useraccountapp.service.FileUserService;
import by.ps.useraccountapp.service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppConfig {

    public static UserRepository getRepository() {

        return new FileUserRepository();
    }

    public static UserService getUserService() {

        return new FileUserService();
    }

    public static Validator getValidator() {

        return new UserInputValidator();
    }

    public static Properties getProperties() {

        Properties properties = new Properties();

        try {
            properties.load(new FileInputStream("message.properties"));
        } catch (IOException e) {
            System.err.println("ERROR: Property file not found!");
        }

        return properties;
    }

    public static Map<Integer, Action> getActions() {

        Map<Integer, Action> actions = new HashMap<>();

        actions.put(1, new ShowUsersAction());
        actions.put(2, new AddUserAction());
        actions.put(3, new UpdateUserAction());
        actions.put(4, new FindUserAction());
        actions.put(5, new RemoveUserAction());

        return actions;
    }
}

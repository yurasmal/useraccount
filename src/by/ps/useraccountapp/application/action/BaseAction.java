package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.application.util.Validator;
import by.ps.useraccountapp.service.UserService;

import java.util.Properties;

public class BaseAction {

    protected UserService userService = AppConfig.getUserService();

    protected Validator validator = AppConfig.getValidator();

    protected Properties properties = AppConfig.getProperties();


}

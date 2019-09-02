package by.ps.useraccountapp.application.config;

import by.ps.useraccountapp.repository.FileUserRepository;
import by.ps.useraccountapp.repository.UserRepository;
import by.ps.useraccountapp.service.FileUserService;
import by.ps.useraccountapp.service.UserService;

public class AppConfig {

    public static UserRepository getRepository() {

        return new FileUserRepository();
    }

    public static UserService getUserService() {

        return new FileUserService();
    }
}

package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.entity.User;

import java.util.List;

public class ShowUsersAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("getAll");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        System.out.println("-----" + ACTION_NAME + "-----");

        List<User> users = userService.findAll();

        for (User user : users) {
            System.out.println(user);
        }
    }
}

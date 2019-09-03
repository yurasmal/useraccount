package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.util.UserInputMessage;
import by.ps.useraccountapp.entity.User;

public class RemoveUserAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("remove");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        System.out.println("-----" + ACTION_NAME + "-----");

        int id = getIntegerValue(UserInputMessage.ID_MESSAGE.toString());

        User user = new User(id);

        userService.removeUser(user);
    }
}

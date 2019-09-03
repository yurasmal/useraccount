package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.util.UserInputMessage;
import by.ps.useraccountapp.entity.User;
import by.ps.useraccountapp.exception.UserNotFoundException;

public class FindUserAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("find");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        System.out.println("-----" + ACTION_NAME + "-----");

        int id = getIntegerValue(UserInputMessage.ID_MESSAGE.toString());

        try {
            User user = userService.findUser(id);
            System.out.println(user);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}

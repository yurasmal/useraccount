package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.util.UserInputMessage;
import by.ps.useraccountapp.entity.User;

import java.util.List;
import java.util.Set;

public class AddUserAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("add");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        System.out.println("-----" + ACTION_NAME + "-----");

        int id = getValidId();

        String firstName = getValidString(UserInputMessage.FIRST_NAME_MESSAGE.toString(),
                                            ALL_PATTERN, null);

        String lastName = getValidString(UserInputMessage.LAST_NAME_MESSAGE.toString(),
                                            ALL_PATTERN, null);

        String email = getValidString(UserInputMessage.EMAIL_MESSAGE.toString(),
                                        EMAIL_PATTERN, EMAIL_ERROR);

        Set<String> roles = getValidSet(UserInputMessage.ROLE_MESSAGE.toString(),
                                        ALL_PATTERN, null);

        Set<String> phoneNumbers = getValidSet(UserInputMessage.PHONE_NUMBER_MESSAGE.toString(),
                                                PHONE_NUMBER_PATTERN, PHONE_ERROR);

        User user = new User(id, firstName, lastName, email, roles, phoneNumbers);

        userService.saveUser(user);
    }

    private int getValidId() {

        boolean flag = false;

        List<User> users = userService.findAll();

        int id = getIntegerValue(UserInputMessage.ID_MESSAGE.toString());

        for (User user : users) {

            if (user.getId() == id) {
                System.out.println("User with ID = " + id + " already exist!");
                flag = true;
            }
        }

        if (!flag) {
            return id;
        }

        return getValidId();
    }
}

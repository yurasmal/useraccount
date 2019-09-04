package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.util.UserInputMessage;
import by.ps.useraccountapp.entity.User;
import by.ps.useraccountapp.exception.UserNotFoundException;

import java.util.Set;

public class UpdateUserAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("update");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        User user = null;

        System.out.println("-----" + ACTION_NAME + "-----");

        int id = getIntegerValue(UserInputMessage.ID_MESSAGE.toString());

        try {
            user = userService.findUser(id);
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        String firstName = getValidString(UserInputMessage.FIRST_NAME_MESSAGE.toString(),
                ALL_PATTERN, null);

        user.setFirstName(firstName);

        String lastName = getValidString(UserInputMessage.LAST_NAME_MESSAGE.toString(),
                ALL_PATTERN, null);

        user.setLastName(lastName);

        String email = getValidString(UserInputMessage.EMAIL_MESSAGE.toString(),
                EMAIL_PATTERN, EMAIL_ERROR);

        user.setEmail(email);

        Set<String> roles = getValidSet(UserInputMessage.ROLE_MESSAGE.toString(),
                ALL_PATTERN, null);

        user.setRoles(roles);

        Set<String> phoneNumbers = getValidSet(UserInputMessage.PHONE_NUMBER_MESSAGE.toString(),
                PHONE_NUMBER_PATTERN, PHONE_ERROR);

        user.setPhoneNumbers(phoneNumbers);

        userService.updateUser(user);
    }
}

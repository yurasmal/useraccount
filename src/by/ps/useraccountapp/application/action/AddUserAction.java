package by.ps.useraccountapp.application.action;

import by.ps.useraccountapp.application.util.UserInputMessage;
import by.ps.useraccountapp.entity.User;

import java.util.Set;

public class AddUserAction extends BaseAction implements Action {

    private static final String ACTION_NAME = properties.getProperty("add");
    private static final String EMAIL_PATTERN = properties.getProperty("pattern.email");
    private static final String PHONE_NUMBER_PATTERN = properties.getProperty("pattern.phone");
    private static final String ALL_PATTERN = properties.getProperty("pattern.all");
    private static final String EMAIL_ERROR = properties.getProperty("email.error");
    private static final String PHONE_ERROR = properties.getProperty("phone.error");

    @Override
    public String getActionName() {
        return ACTION_NAME;
    }

    @Override
    public void execute() {

        System.out.println("-----" + ACTION_NAME + "-----");

        int id = getIntegerValue(UserInputMessage.ID_MESSAGE.toString());

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

}

package by.ps.useraccountapp.application.util;

public enum UserInputMessage {

    ID_MESSAGE("Enter ID:"),
    FIRST_NAME_MESSAGE("Enter first name:"),
    LAST_NAME_MESSAGE("Enter last name:"),
    EMAIL_MESSAGE("Enter email:"),
    ROLE_MESSAGE("Enter roles [0 - exit]:"),
    PHONE_NUMBER_MESSAGE("Enter phone numbers [0 - exit]:");

    private String description;

    UserInputMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
}

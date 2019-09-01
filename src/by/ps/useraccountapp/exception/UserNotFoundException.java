package by.ps.useraccountapp.exception;

public class UserNotFoundException extends Exception {

    public String getMessage() {
        return "User not found...";
    }
}

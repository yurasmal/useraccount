package by.ps.useraccountapp.application;

import by.ps.useraccountapp.application.action.Action;
import by.ps.useraccountapp.application.config.AppConfig;
import by.ps.useraccountapp.application.util.UserInputReader;
import by.ps.useraccountapp.exception.StopApplicationException;

import java.util.Map;

public class Application {

    private Map<Integer, Action> actions;

    public void start() {

        actions = AppConfig.getActions();
        run();
    }

    private void run() {

        while (true) {

            try {
                Action action = getUserChoice();
                action.execute();
            } catch (StopApplicationException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

    private Action getUserChoice() throws StopApplicationException {

        showMenu();

        int index = UserInputReader.getInt();
        if (index == 0) {
            throw new StopApplicationException();
        }

        Action action = actions.get(index);
        if (action == null) {
            return getUserChoice();
        }

        return action;
    }

    private void showMenu() {

        System.out.println("Select action: ");

        for (Map.Entry<Integer, Action> action : actions.entrySet()) {

            System.out.println(action.getKey() + " - " + action.getValue().getActionName());
        }
        System.out.println("0 - Exit");
    }
}

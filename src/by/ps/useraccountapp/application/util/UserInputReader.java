package by.ps.useraccountapp.application.util;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UserInputReader {

    private static Scanner scanner = new Scanner(System.in);

    public static int getInt() {

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }

        System.out.println("Enter integer value, please");
        scanner.next();

        return getInt();
    }

    public static String getString() {
        return scanner.next();
    }

    public static Set<String> getStringSet() {

        Set<String> stringSet = new HashSet<>();

        System.out.println("Enter values [0 - exit]");

        while (true) {

            if (scanner.hasNextInt()) {
                int intValue = scanner.nextInt();
                if (intValue == 0) break;
            }

            String stringValue = getString();

            stringSet.add(stringValue);
        }

        return stringSet;
    }
}

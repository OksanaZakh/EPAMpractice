package MutableStringTask;

import java.lang.reflect.Field;
import java.util.Scanner;

public class MutableString {

    public static final String MENU = "Welcome to mutable string app\nAvailable actions:" +
            "\npress\n1 - change phrase \"String is immutable\" to \"String is mutable\"" +
            "\n2 - print your own string and change it" +
            "\n0 - quit";
    public static final String NUMBERS_IN_RANGE = "Please insert numbers from 0 - 2";
    public static final String PRINT_STRING = "Please print a string";
    public static final String PRINT_STRING_FOR_REPLACE = "Please print a string for replacement";
    public static final String OLD_STRING = "Old string:\t";
    public static final String NEW_OLD_STRING = "New value of old string:\t";


    private Scanner scanner;
    private String string;

    public MutableString() {
        this.scanner = new Scanner(System.in);
        string = "String is immutable";
    }

    public void run() {
        System.out.println(MENU);
        boolean quit = false;
        int option = scanner.nextInt();
        while (!quit) {
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    changeProvidedString();
                    option = scanner.nextInt();
                    break;
                case 2:
                    changeInputString();
                    option = scanner.nextInt();
                    break;
                default:
                    System.out.println(NUMBERS_IN_RANGE);
                    break;
            }
        }
    }

    private void changeProvidedString() {
        String newString = "String is mutable";
        makeReplacement(string, newString);
    }

    private void changeInputString() {
        System.out.println(PRINT_STRING);
        String userString = scanner.nextLine();
        System.out.println(PRINT_STRING_FOR_REPLACE);
        String newUserString = scanner.nextLine();
        makeReplacement(userString, newUserString);
    }

    private void makeReplacement(String old, String newString) {
        char[] chars = newString.toCharArray();
        System.out.println(OLD_STRING + old);
        Class classs = old.getClass();
        try {
            Field field = classs.getDeclaredField("value");
            field.setAccessible(true);
            field.set(old, chars);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.getMessage();
        }
        System.out.println(NEW_OLD_STRING + old);
    }
}

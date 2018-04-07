package com.oksana.zakharchenko.journalmvc.Utils;

public class Constants {

    public static final String EXIT = "Exit";
    public static final String NUMBERS_IN_RANGE = "Please enter the number in range 0 - 4";
    public static final String PRINT_NAME="Please print name of new student";
    public static final String PRINT_SECOND_NAME="Please print surname of new student";
    public static final String WRONG_INPUT_DATA = "Input data is wrong, please try again";

    public static final String DONE="Done!";
    public static final String PRINT_BIRTHDAY="Enter date of birth in format YYYY-MM-DD";
    public static final String PRINT_PHONE_NUMBER="Enter the phone number";
    public static final String PRINT_ADDRESS="Please enter the address in format \"111 Aaaaaa Bbbb\" or \"222 c Dddd Eeeee\"";
    public static final String FAIL="Such entry already exist!";

    public static final String NAME_REGEX="[A-Z]{1}[a-z]{1,30}";
    public static final String BIRTHDAY_REGEX="^\\d{4}-\\d{2}-\\d{2}$";
    public static final String PHONE_NUM_REGEX="\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
    public static final String ADDRESS_REGEX="\\d+\\s+(([a-zA-Z])+|([a-zA-Z]+\\s+[a-zA-Z]+))\\s+[a-zA-Z]*";
}

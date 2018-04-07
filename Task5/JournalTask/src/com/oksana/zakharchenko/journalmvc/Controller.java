package com.oksana.zakharchenko.journalmvc;

import com.oksana.zakharchenko.journalmvc.JornalModel.JournalEntry;
import com.oksana.zakharchenko.journalmvc.JornalModel.ModelManager;
import com.oksana.zakharchenko.journalmvc.Utils.Constants;
import com.oksana.zakharchenko.journalmvc.Utils.InputValidate;
import com.oksana.zakharchenko.journalmvc.Utils.Utils;


public class Controller {
    private ModelManager modelManager;
    private View view;
    private Utils utils;
    private InputValidate inputValidate;


    public Controller(ModelManager modelManager, View view) {
        this.modelManager = modelManager;
        this.view = view;
        utils = new Utils(view);
        inputValidate = new InputValidate();
    }

    public void run() {
        boolean quit = false;
        view.printMenu();
        while (!quit) {
            int action = utils.inputIntValueWithScanner();
            utils.goForward();
            switch (action) {
                case 0:
                    view.printData(Constants.EXIT);
                    quit = true;
                    break;
                case 1:
                    addNewEntry();
                    break;
                case 2:
                    showJournal();
                    break;
                case 3:
                    view.printMenu();
                    break;
                default:
                    view.printData(Constants.NUMBERS_IN_RANGE);
                    view.printMenu();
                    break;
            }
        }

    }

    private void addNewEntry() {
        view.printData(Constants.PRINT_NAME);
        JournalEntry entry = new JournalEntry();
        String input=getInput(Constants.NAME_REGEX);
        entry.setFirstName(input);
        view.printData(Constants.PRINT_SECOND_NAME);
        input=getInput(Constants.NAME_REGEX);
        entry.setSecondName(input);
        view.printData(Constants.PRINT_BIRTHDAY);
        input=getInput(Constants.BIRTHDAY_REGEX);
        entry.setBirthday(input);
        view.printData(Constants.PRINT_PHONE_NUMBER);
        input=getInput(Constants.PHONE_NUM_REGEX);
        entry.setPhoneNum(input);
        view.printData(Constants.PRINT_ADDRESS);
        input=getInput(Constants.ADDRESS_REGEX);
        entry.setAddress(input);
        if (modelManager.addEntry(entry)) {
            view.printData(Constants.DONE);
        } else {
            view.printData(Constants.FAIL);
        }
    }

    private void showJournal() {
        view.printData(modelManager.getJournal().toString());
    }

    private String getInput(String regex){
        String input=utils.inputStringWithScanner();
        while (!inputValidate.validate(regex, input)){
            view.printData(Constants.WRONG_INPUT_DATA);
            input=utils.inputStringWithScanner();
        }
        return input;
    }
}


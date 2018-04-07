package mvcpatients;


import mvcpatients.Model.Model;
import mvcpatients.Model.Patient;
import mvcpatients.Utils.Constants;
import mvcpatients.Utils.Utils;

import java.util.List;

public class Controller {

    View view;
    Model model;
    Utils utils;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        utils = new Utils(view);
    }

    public void processPatients() {
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
                    getPatientsWithDisease();
                    break;
                case 2:
                    getPatientsInRangeOfCards();
                    break;
                case 3:
                    sortPatientsOnLastName();
                    break;
                case 4:
                    printSortedOnCardsPatients();
                    break;
                case 5:
                    view.printMenu();
                    break;
                default:
                    view.printData(Constants.NUMBERS_IN_RANGE);
                    view.printMenu();
                    break;
            }
        }
    }

    private void getPatientsWithDisease() {
        view.printData(Constants.ENTER_DISEASE);
        String disease = utils.inputStringValueWithScanner();
        List<Patient> patientsWithDisease = model.getPatientsWithDisease(disease);
        view.printList(patientsWithDisease);
    }

    private void getPatientsInRangeOfCards() {
        view.printData(Constants.START_NUMBER);
        int rangeStart = utils.inputIntValueWithScanner();
        utils.goForward();
        view.printData(Constants.END_NUMBER);
        int rangeEnd = utils.inputIntValueWithScanner();
        utils.goForward();
        List<Patient> patientsInRange = model.getPatientsInRange(rangeStart, rangeEnd);
        view.printList(patientsInRange);
    }

    private void sortPatientsOnLastName() {
        List<Patient> patients = model.sortPatientsOnLastName();
        view.printData(Constants.SORTED_IN_ALPHABETIC_ORDER);
        view.printList(patients);
    }

    private void printSortedOnCardsPatients() {
        view.printData(Constants.LIST_OF_PATIENTS);
        List<Patient> patients = model.sortPatients();
        view.printList(patients);
    }

}

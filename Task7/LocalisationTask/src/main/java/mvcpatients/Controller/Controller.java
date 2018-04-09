package mvcpatients.Controller;


import mvcpatients.Model.Model;
import mvcpatients.Model.Patient;
import mvcpatients.Controller.Constants.Constants;
import mvcpatients.Controller.Constants.LogMassages;
import mvcpatients.Utils.LocalisationHalper.ResourceManager;
import mvcpatients.Utils.Scanner.CustomScanner;
import mvcpatients.Utils.FileHalpers.FileHandler;
import mvcpatients.View.View;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;
import java.util.Locale;


public class Controller {
    final static Logger logger = Logger.getLogger(Controller.class);

    private View view;
    private Model model;
    private CustomScanner customScanner;
    private FileHandler fileHandel;
    private boolean isFileCreated;
    private ResourceManager resourceManager;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        customScanner = new CustomScanner(view);
        fileHandel = new FileHandler();
        isFileCreated = false;
        resourceManager = ResourceManager.INSTANCE;
    }


    public void processPatients() {
        boolean quit = false;
        printMenu();
        while (!quit) {
            int action = customScanner.inputIntValueWithScanner();
            customScanner.goForward();
            switch (action) {
                case 0:
                    view.printData(resourceManager.getString(Constants.EXIT));
                    saveAllPatients();
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
                    addNewPatient();
                    break;
                case 6:
                    saveAllPatients();
                    break;
                case 7:
                    readPatientsFromFile();
                    break;
                case 8:
                    saveDataToDirectory();
                    break;
                case 9:
                    changeLanguage();
                    break;
                case 10:
                    printMenu();
                    break;
                default:
                    view.printData(resourceManager.getString(Constants.NUMBERS_IN_RANGE));
                    printMenu();
                    break;
            }
        }
    }

    private void getPatientsWithDisease() {
        logger.info(LogMassages.GET_PATIENTS_WITH_DISEASE);
        view.printData(resourceManager.getString(Constants.ENTER_DISEASE));
        String disease = customScanner.inputStringValueWithScanner();
        List<Patient> patientsWithDisease = model.getPatientsWithDisease(disease);
        view.printList(patientsWithDisease);
    }

    private void getPatientsInRangeOfCards() {
        logger.info(LogMassages.GET_PATIENTS_WITH_CARDS);
        view.printData(resourceManager.getString(Constants.START_NUMBER));
        int rangeStart = customScanner.inputIntValueWithScanner();
        customScanner.goForward();
        view.printData(resourceManager.getString(Constants.END_NUMBER));
        int rangeEnd = customScanner.inputIntValueWithScanner();
        customScanner.goForward();
        List<Patient> patientsInRange = model.getPatientsInRange(rangeStart, rangeEnd);
        view.printList(patientsInRange);
    }

    private void sortPatientsOnLastName() {
        logger.info(LogMassages.SORT_PATIENTS);
        List<Patient> patients = model.sortPatientsOnLastName();
        view.printData(resourceManager.getString(Constants.SORTED_IN_ALPHABETIC_ORDER));
        view.printList(patients);
    }

    private void printSortedOnCardsPatients() {
        logger.info(LogMassages.SORT_PATIENTS);
        view.printData(resourceManager.getString(Constants.LIST_OF_PATIENTS));
        List<Patient> patients = model.sortPatients();
        view.printList(patients);
    }

    private void addNewPatient() {
        logger.info(LogMassages.ADD_NEW_PATIENT);
        view.printData(resourceManager.getString(Constants.NEW_PATIENT));
        view.printData(resourceManager.getString(Constants.NEW_PATIENT_NAME));
        String name = customScanner.inputStringValueWithScanner();
        view.printData(resourceManager.getString(Constants.NEW_PATIENT_SECOND_NAME));
        String secondName = customScanner.inputStringValueWithScanner();
        view.printData(resourceManager.getString(Constants.NEW_PATIENTS_PATRONYMIC));
        String patronymic = customScanner.inputStringValueWithScanner();
        view.printData(resourceManager.getString(Constants.NEW_PATIENT_ADDRESS));
        String address = customScanner.inputStringValueWithScanner();
        view.printData(resourceManager.getString(Constants.NEW_PATIENT_PHONE));
        String phone = customScanner.inputStringValueWithScanner();
        view.printData(resourceManager.getString(Constants.NEW_PATIENT_DIAGNOSE));
        String disease = customScanner.inputStringValueWithScanner();
        Patient patient = new Patient(name, secondName, patronymic, address, phone, disease);
        if (model.addNewPatients(patient)) {
            view.printData(resourceManager.getString(Constants.DONE));
            logger.info(LogMassages.NEW_PATIENT_ADDED);
        } else {
            view.printData(resourceManager.getString(Constants.FAIL));
            logger.error(LogMassages.FAIL_ADD_NEW_PATIENT);
        }
    }

    private void saveAllPatients() {
        logger.info(LogMassages.SAVE_PATIENTS);
        if (!isFileCreated) {
            view.printData(resourceManager.getString(Constants.FILE_NAME));
            String fileName = customScanner.inputStringValueWithScanner();
            if (fileName.isEmpty() || fileHandel.isFileExist(fileName)) {
                view.printData(resourceManager.getString(Constants.WRONG_INPUT_DATA));
                logger.error(LogMassages.FILENAME_INCORRECT);
                return;
            }
            if (!fileName.isEmpty()) {
                if (fileHandel.createFile(fileName)) {
                    view.printData(resourceManager.getString(Constants.FILE_CREATED));
                    isFileCreated = true;
                } else {
                    logger.error(LogMassages.FAIL_CREATE_FILE);
                    view.printData(resourceManager.getString(Constants.FAIL));
                }
            }
        }
        if (fileHandel.writePatients(model)) {
            view.printData(resourceManager.getString(Constants.DONE));
        } else {
            view.printData(resourceManager.getString(Constants.FAIL));
        }

    }

    private void readPatientsFromFile() {
        logger.info(LogMassages.READ_FROM_FILE);
        if (!isFileCreated) {
            view.printData(resourceManager.getString(Constants.FAIL_READ));
            return;
        }
        Model newModel = fileHandel.readPatients();
        if (newModel != null) {
            view.printList(newModel.getPatients());
        } else {
            view.printData(resourceManager.getString(Constants.FAIL_READ));
            logger.error(LogMassages.FAIL_READ_FROM_FILE);
        }
    }

    private void saveDataToDirectory() {
        logger.info(LogMassages.SAVE_TO_DIRECTORY);
        view.printData(resourceManager.getString(Constants.PRINT_DIRECTORY));
        String dir = customScanner.inputStringValueWithScanner();
        File file = new File(dir);
        if (file.isDirectory()) {
            fileHandel.setPath(dir);
            isFileCreated = false;
            saveAllPatients();
        } else {
            view.printData(resourceManager.getString(Constants.DIRECTORY_FAIL));
            logger.error(LogMassages.FAIL_TO_SAVE_TO_DIRECTORY);
        }
    }

    public void changeLanguage() {
        view.printData(resourceManager.getString(Constants.SWITCH_LANGUAGE));
        int num=customScanner.inputIntValueWithScanner();
        switch (num){
            case 1:
                resourceManager.changeResource(new Locale("en", "GB"));
                view.printData(resourceManager.getString(Constants.DONE));
                break;
            case 2:
                resourceManager.changeResource(new Locale("ru", "RU"));
                view.printData(resourceManager.getString(Constants.DONE));
                break;
                default:
                    view.printData(resourceManager.getString(Constants.FAIL));
                    view.printData(resourceManager.getString(Constants.WRONG_INPUT_DATA));
        }
    }

    public void printMenu() {
        view.printData(resourceManager.getString(Constants.ACTIONS));
        view.printData(resourceManager.getString(Constants.MENU));
    }

}

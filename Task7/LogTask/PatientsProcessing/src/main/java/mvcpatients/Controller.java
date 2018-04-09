package mvcpatients;


import mvcpatients.Model.Model;
import mvcpatients.Model.Patient;
import mvcpatients.Utils.Constants;
import mvcpatients.Utils.LogMassages;
import mvcpatients.Utils.Utils;
import mvcpatients.Utils.FileHandler;
import org.apache.log4j.Logger;

import java.io.File;
import java.util.List;


public class Controller {
    final static Logger logger = Logger.getLogger(Controller.class);

    private View view;
    private Model model;
    private Utils utils;
    private FileHandler fileHandel;
    private boolean isFileCreated;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        utils = new Utils(view);
        fileHandel = new FileHandler();
        isFileCreated = false;

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
        logger.info(LogMassages.GET_PATIENTS_WITH_DISEASE);
        view.printData(Constants.ENTER_DISEASE);
        String disease = utils.inputStringValueWithScanner();
        List<Patient> patientsWithDisease = model.getPatientsWithDisease(disease);
        view.printList(patientsWithDisease);
    }

    private void getPatientsInRangeOfCards() {
        logger.info(LogMassages.GET_PATIENTS_WITH_CARDS);
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
        logger.info(LogMassages.SORT_PATIENTS);
        List<Patient> patients = model.sortPatientsOnLastName();
        view.printData(Constants.SORTED_IN_ALPHABETIC_ORDER);
        view.printList(patients);
    }

    private void printSortedOnCardsPatients() {
        logger.info(LogMassages.SORT_PATIENTS);
        view.printData(Constants.LIST_OF_PATIENTS);
        List<Patient> patients = model.sortPatients();
        view.printList(patients);
    }

    private void addNewPatient() {
        logger.info(LogMassages.ADD_NEW_PATIENT);
        view.printData(Constants.NEW_PATIENT);
        view.printData(Constants.NEW_PATIENT_NAME);
        String name = utils.inputStringValueWithScanner();
        view.printData(Constants.NEW_PATIENT_SECOND_NAME);
        String secondName = utils.inputStringValueWithScanner();
        view.printData(Constants.NEW_PATIENTS_PATRONYMIC);
        String patronymic = utils.inputStringValueWithScanner();
        view.printData(Constants.NEW_PATIENT_ADDRESS);
        String address = utils.inputStringValueWithScanner();
        view.printData(Constants.NEW_PATIENT_PHONE);
        String phone = utils.inputStringValueWithScanner();
        view.printData(Constants.NEW_PATIENT_DIAGNOSE);
        String disease = utils.inputStringValueWithScanner();
        Patient patient = new Patient(name, secondName, patronymic, address, phone, disease);
        if (model.addNewPatients(patient)) {
            view.printData(Constants.DONE);
            logger.info(LogMassages.NEW_PATIENT_ADDED);
        } else {
            view.printData(Constants.FAIL);
            logger.error(LogMassages.FAIL_ADD_NEW_PATIENT);
        }
    }

    private void saveAllPatients() {
        logger.info(LogMassages.SAVE_PATIENTS);
        if (!isFileCreated) {
            view.printData(Constants.FILE_NAME);
            String fileName = utils.inputStringValueWithScanner();
            if (fileName.isEmpty() || fileHandel.isFileExist(fileName)) {
                view.printData(Constants.WRONG_INPUT_DATA);
                logger.error(LogMassages.FILENAME_INCORRECT);
                return;
            }
            if (!fileName.isEmpty()) {
                if (fileHandel.createFile(fileName)) {
                    view.printData(Constants.FILE_CREATED);
                    isFileCreated = true;
                } else {
                    logger.error(LogMassages.FAIL_CREATE_FILE);
                    view.printData(Constants.FAIL);
                }
            }
        }
        if (fileHandel.writePatients(model)) {
            view.printData(Constants.DONE);
        } else {
            view.printData(Constants.FAIL);
        }

    }

    private void readPatientsFromFile() {
        logger.info(LogMassages.READ_FROM_FILE);
        if (!isFileCreated) {
            view.printData(Constants.FAIL_READ);
            return;
        }
        Model newModel = fileHandel.readPatients();
        if (newModel != null) {
            view.printList(newModel.getPatients());
        } else {
            view.printData(Constants.FAIL_READ);
            logger.error(LogMassages.FAIL_READ_FROM_FILE);
        }
    }

    private void saveDataToDirectory() {
        logger.info(LogMassages.SAVE_TO_DIRECTORY);
        view.printData(Constants.PRINT_DIRECTORY);
        String dir = utils.inputStringValueWithScanner();
        File file = new File(dir);
        if (file.isDirectory()) {
            fileHandel.setPath(dir);
            isFileCreated = false;
            saveAllPatients();
        } else {
            view.printData(Constants.DIRECTORY_FAIL);
            logger.error(LogMassages.FAIL_TO_SAVE_TO_DIRECTORY);
        }
    }

}

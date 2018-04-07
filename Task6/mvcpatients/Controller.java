package mvcpatients;


import mvcpatients.Model.Model;
import mvcpatients.Model.Patient;
import mvcpatients.Utils.Constants;
import mvcpatients.Utils.Utils;
import mvcpatients.Utils.WriterAndReader;

import java.util.List;

public class Controller {

    private View view;
    private Model model;
    private Utils utils;
    private WriterAndReader writerAndReader;
    private boolean isFileCreated;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        utils = new Utils(view);
        writerAndReader=new WriterAndReader();
        isFileCreated=false;
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

    private void addNewPatient() {
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
        } else view.printData(Constants.FAIL);
    }

    private void saveAllPatients() {
        if(!isFileCreated){
            view.printData(Constants.FILE_NAME);
            String fileName=utils.inputStringValueWithScanner();
            if(fileName.isEmpty()|| writerAndReader.isFileExist(fileName)){
                view.printData(Constants.WRONG_INPUT_DATA);
                return;
            }
            if(!fileName.isEmpty()) {
                if(writerAndReader.createFile(fileName)){
                    view.printData(Constants.FILE_CREATED);
                }
                else view.printData(Constants.FAIL);
            }
            isFileCreated=true;
        }
        writerAndReader.writePatients(model);
        view.printData(Constants.DONE);
    }

    private void readPatientsFromFile(){
        if(!isFileCreated){
            view.printData(Constants.FAIL_READ);
            return;
        }
        Model newModel=writerAndReader.readPatients();
        if(newModel!=null){
           view.printList(newModel.getPatients());
        }
        else{
            view.printData(Constants.FAIL_READ);
        }
    }

}

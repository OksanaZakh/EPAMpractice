package mvcpatients.View;

import mvcpatients.Controller.Constants.Constants;
import mvcpatients.Model.Patient;

import java.util.List;

public class View {


    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println(Constants.ACTIONS);
        System.out.println(Constants.MENU);
    }

    public void printList(List<Patient> patients) {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }
}

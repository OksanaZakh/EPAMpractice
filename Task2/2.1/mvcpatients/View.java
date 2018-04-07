package mvcpatients;

import mvcpatients.Model.Patient;

import java.util.List;

public class View {


    public void printData(String data) {
        System.out.println(data);
    }

    public void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - get patients with particular disease\n" +
                "2 - get patients with the card number in range\n" +
                "3 - sort patient in alphabetic order\n" +
                "4 - print all patients\n" +
                "5 - print available actions.\n");
    }

    public void printList(List<Patient> patients) {
        if (patients.size() == 0) {
            printData("There is no such patents");
        }
        for (Patient patient : patients) {
            System.out.println(patient);
        }

    }
}

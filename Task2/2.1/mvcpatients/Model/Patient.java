package mvcpatients.Model;

import java.util.Comparator;

public class Patient implements Comparable<Patient> {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String address;
    private String phone;
    private int medicalCardNumber;
    private String diagnosis;
    private static int numOfPatients = 1;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String patronymic, String address, String phone, String diagnosis) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.address = address;
        this.phone = phone;
        this.medicalCardNumber = numOfPatients++;
        this.diagnosis = diagnosis.toLowerCase();
    }


    public int compareTo(Patient other) {

        if (this.medicalCardNumber == other.getMedicalCardNumber()) {
            return 0;
        } else if (this.medicalCardNumber < other.getMedicalCardNumber()) {
            return -1;
        } else {
            return 1;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public int getMedicalCardNumber() {
        return medicalCardNumber;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", medicalCardNumber=" + medicalCardNumber +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }

    public static int getNumOfPatients() {
        return numOfPatients;
    }

    public static Comparator<Patient> lastNameComparator = new Comparator<Patient>() {

        public int compare(Patient patient1, Patient patient2) {

            String lastName1 = patient1.getLastName();
            String lastName2 = patient2.getLastName();
            return lastName1.compareTo(lastName2);
        }

    };
}

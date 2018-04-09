package mvcpatients.Model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

public class Patient implements Comparable<Patient>, Serializable {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return medicalCardNumber == patient.medicalCardNumber &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(patronymic, patient.patronymic);
    }

    @Override
    public int hashCode() {
        int res=17;
        res=31*res+firstName.hashCode();
        res=31*res+lastName.hashCode();
        res=31*res+patronymic.hashCode();
        res=31*res+medicalCardNumber;
        return res;
    }

}

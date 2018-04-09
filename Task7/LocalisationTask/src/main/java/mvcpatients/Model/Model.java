package mvcpatients.Model;

import mvcpatients.Utils.FileHalpers.JsonParser;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Model implements Serializable {

    List<Patient> patients;

    public Model() {
        patients = JsonParser.getJsonPatients();
    }
    public Model(List<Patient> patients){
        this.patients=patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Patient> getPatientsWithDisease(String disease) {
        List<Patient> patientsWithDisease = new ArrayList<>();
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equalsIgnoreCase(disease)) {
                patientsWithDisease.add(patient);
            }
        }
        return patientsWithDisease;
    }

    public List<Patient> getPatientsInRange(int rangeStart, int rangeEnd) {
        List<Patient> patientsInRange = new ArrayList<>();
        if (Patient.getNumOfPatients() < rangeStart || rangeEnd < 0) {
            return patientsInRange;
        } else {
            for (Patient patient : patients) {
                if (patient.getMedicalCardNumber() >= rangeStart && patient.getMedicalCardNumber() <= rangeEnd) {
                    patientsInRange.add(patient);
                }
            }
        }
        return patientsInRange;
    }

    public List<Patient> sortPatients() {
        Collections.sort(patients);
        return patients;
    }

    public List<Patient> sortPatientsOnLastName() {
        patients.sort(Patient.lastNameComparator);
        return patients;
    }

    public boolean addNewPatients(Patient patient){
        if(!patients.contains(patient)){
            patients.add(patient);
            return true;
        }
        else{
            return false;
        }
    }
}

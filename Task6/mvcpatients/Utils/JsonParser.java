package mvcpatients.Utils;

import mvcpatients.Model.Patient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static List<Patient> getJsonPatients() {
        List<Patient> patients = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(
                    "C:\\Users\\Administrator\\IdeaProjects\\PatientsProcessing\\patients_json.iml"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray patientsList = (JSONArray) jsonObject.get("patients");

            for (Object object : patientsList) {
                JSONObject patientObject = (JSONObject) object;

                String firstName = (String) patientObject.get("firstName");
                String lastName = (String) patientObject.get("lastName");
                String patronymic = (String) patientObject.get("patronymic");
                String address = (String) patientObject.get("address");
                String phone = (String) patientObject.get("phone");
                String diagnosis = (String) patientObject.get("diagnosis");
                Patient patient = new Patient(firstName, lastName, patronymic, address, phone, diagnosis);
                patients.add(patient);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }
}

package mvcpatients.Utils.FileHalpers;

import mvcpatients.Model.Model;
import mvcpatients.Controller.Constants.LogMassages;
import org.apache.log4j.Logger;

import java.io.*;

public class FileHandler {

    private Logger logger;
    private String path;
    private File file;

    public FileHandler() {
        this.path = "C:\\Users\\Administrator\\IdeaProjects\\PatientsProcessing\\";
        file = null;
        logger = Logger.getLogger(FileHandler.class);
    }

    public boolean isFileExist(String name) {
        File file = new File(path + name + ".txt");
        return file.exists();
    }

    public boolean createFile(String name) {
        file = new File(path + name + ".txt");
        boolean fileIsCreated = false;
        if (!file.exists()) {
            try {
                fileIsCreated = file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                logger.error(LogMassages.FAIL_CREATE_FILE);
            }
        }
        return fileIsCreated;
    }

    public boolean writePatients(Model model) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(model);
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            logger.error(LogMassages.FAIL_SAVE_DATA);
            return false;
        }

    }

    public Model readPatients() {
        Model newModel = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))) {
            newModel = (Model) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            logger.error(LogMassages.FAIL_READ_FROM_FILE);
        }
        return newModel;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

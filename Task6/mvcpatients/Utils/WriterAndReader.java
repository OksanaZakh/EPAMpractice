package mvcpatients.Utils;

import mvcpatients.Model.Model;

import javax.naming.spi.DirectoryManager;
import java.io.*;

public class WriterAndReader {

    private String path;
    private File file;

    public WriterAndReader() {
        this.path = "C:\\Users\\Administrator\\IdeaProjects\\PatientsProcessing\\";
        file = null;
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
            }
        }
        return fileIsCreated;
    }

    public void writePatients(Model model){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
            outputStream.writeObject(model);
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public Model readPatients() {
        Model newModel = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            newModel = (Model) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return newModel;
    }


}

package Threads.DirectoryProcessing;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class DirectoryRunner {
    private Scanner sc;

    public DirectoryRunner() {
        this.sc = new Scanner(System.in);
    }

    public void run() {
        System.out.print("Enter directory -> ");
        String dir = sc.next();
        System.out.print("Enter char -> ");
        String word = sc.next();
        char ch = word.charAt(0);
        String results = runDirectory(dir, ch);
        String resDir = enterDirForSaving();
        String resFilename = enterFileNameForSave(resDir);
        if (createFile(resFilename)) {
            System.out.println("File created!");
        } else {
            System.out.println("Error!");
        }
        if (writeFile(resFilename, results)) {
            System.out.println("Data is written!");
        } else {
            System.out.println("Error!");
        }
        System.out.println("Data recorded in file:");
        if (readFile(resFilename)) {
            System.out.println("App is finished!");
        } else {
            System.out.println("Error!");
        }
    }

    private String runDirectory(String dir, char ch) {
        DirectoryProcessor counter = new DirectoryProcessor(new File(dir), ch);
        FutureTask<Map<String, Integer>> task = new FutureTask<>(counter);
        new Thread(task).start();
        try {
            return (printResults(task.get()));
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
            return "";
        }
    }

    private String printResults(Map<String, Integer> map) {
        String res = "";
        for (String s : map.keySet()) {
            res += "File " + s + " have " + map.get(s) + " words\n";
        }
        return res;
    }

    private boolean createFile(String name) {
        File file = new File(name);
        boolean fileIsCreated = false;
        if (!file.exists()) {
            try {
                fileIsCreated = file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return fileIsCreated;
    }

    private boolean writeFile(String fileName, String data) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter
                (new FileOutputStream(fileName), StandardCharsets.UTF_8))) {
            writer.write(data);
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }


    private boolean readFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String st;
            while ((st = br.readLine()) != null)
                System.out.println(st);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private String enterDirForSaving() {
        System.out.print("Enter directory for saving results -> ");
        String resDir = sc.next();
        while (!(new File(resDir)).isDirectory()) {
            System.out.println("Please enter valid directory!");
            resDir = sc.next();
        }
        return resDir;
    }

    private String enterFileNameForSave(String resDir) {
        System.out.print("Enter filename for saving results -> ");
        String filename = sc.next();
        while ((new File(resDir + "//" + filename)).exists()) {
            System.out.println("Such file is already exist, try again!");
            resDir = sc.next();
        }
        return resDir + "//" + filename + ".txt";
    }
}

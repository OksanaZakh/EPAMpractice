package Threads.DirectoryProcessing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class DirectoryProcessor implements Callable<Map<String, Integer>> {

    private File dir;
    private char ch;

    public DirectoryProcessor(File dir, char ch) {
        this.dir = dir;
        this.ch = ch;
    }


    public int search(File ff) {
        try (Scanner sc = new Scanner(new FileInputStream(ff))) {
            int count = 0;
            while (sc.hasNextLine()) {
                String str = sc.nextLine();
                String[] array = str.trim().split("\\s");
                for (String s : array) {
                    if (!s.isEmpty()) {
                        if (s.charAt(0) == ch) {
                            count++;
                        }
                    }
                }
            }
            return count;
        } catch (FileNotFoundException e) {
            return 0;
        }
    }

    public Map<String, Integer> call() {
        Map<String, Integer> map = new HashMap<>();
        try {
            File[] files = dir.listFiles();
            ArrayList<Future<Map<String, Integer>>> result = new ArrayList<>();
            for (File ff : files)
                if (ff.isDirectory()) {
                    DirectoryProcessor counter = new DirectoryProcessor(ff, ch);
                    FutureTask<Map<String, Integer>> task = new FutureTask<>(counter);
                    result.add(task);
                    new Thread(task).start();
                } else if (search(ff) > 0)
                    map.put(ff.getName(), search(ff));
            for (Future<Map<String, Integer>> rez : result)
                if (rez.get().size() != 0) {
                    for (String currStr : rez.get().keySet()) {
                        map.put(currStr, rez.get().get(currStr));
                    }
                }
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }
}

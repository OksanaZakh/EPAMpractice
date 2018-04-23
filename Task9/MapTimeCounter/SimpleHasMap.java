package Threads.HashTimeCounter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class SimpleHasMap {
    private volatile Map<Integer, String> map;
    private int numWorks;
    private int numThreads;
    private double averageReadingTime;
    private double averageWritingTime;
    private boolean isMapWritten;
    private int maxNumOfThreads;

    public SimpleHasMap(int numWorks, int numThreads, int maxNumOfThreads) {
        this.map = new HashMap<>(1000, 0.8f);
        isMapWritten = false;
        this.numWorks=numWorks;
        this.numThreads=numThreads;
        this.maxNumOfThreads=maxNumOfThreads;
    }

    public void runHashMap(){
        runWriting();
        if (isMapWritten){
            runReading();
        }
    }

    private void runWriting() {
        List<Long> timeResults = new ArrayList<>();
        long startTime;
        ExecutorService pool = Executors.newFixedThreadPool(maxNumOfThreads);
        Thread[] threads = new Thread[numThreads];
        Future[] futures = new Future[numThreads];
        for (int k = 0; k < numWorks; k++) {
            startTime = System.currentTimeMillis();
            for (int i = 0; i < numThreads; i++) {
                threads[i] = new WritingThread(i);
                futures[i] = pool.submit(threads[i]);
            }
            int count = 0;
            for (int l = 0; l < numThreads; l++) {
                try {
                    futures[l].get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            timeResults.add(System.currentTimeMillis() - startTime);
        }
        averageWritingTime = timeResults.stream().mapToDouble(n -> n).average().getAsDouble();
        isMapWritten=true;
    }

    private void runReading() {
        List<Long> timeResults = new ArrayList<>();
        long startTime = 0;
        ExecutorService pool = Executors.newFixedThreadPool(4);
        Thread[] threads = new Thread[numThreads];
        Future[] futures = new Future[numThreads];
        for (int k = 0; k < numWorks; k++) {
            startTime = System.currentTimeMillis();
            for (int i = 0; i < numThreads; i++) {
                threads[i] = new Thread(() -> {
                    for (String s : map.values()) {
                        synchronized (this){
                            System.out.println(s);
                        }
                    }
                });
                futures[i] = pool.submit(threads[i]);
            }
            for (int l = 0; l < numThreads; l++) {
                try {
                    futures[l].get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            timeResults.add(System.currentTimeMillis() - startTime);
        }
        averageReadingTime = timeResults.stream().mapToDouble(n -> n).average().getAsDouble();
    }

    public double getAverageReadingTime() {
        return averageReadingTime;
    }

    public double getAverageWritingTime() {
        return averageWritingTime;
    }

    class WritingThread extends Thread {
        int i;

        public WritingThread(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            for (int k = 0; k < 1000; k++) {
                synchronized (this) {
                    map.put(k, "tread" + i);
                }
            }
        }

    }
}

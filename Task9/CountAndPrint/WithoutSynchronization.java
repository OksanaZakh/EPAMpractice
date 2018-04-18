package Threads.CountAndPrint;

public class WithoutSynchronization {
    private int counter = 0;

    public void run() {
        Thread count = new Thread(() -> {
            int value = 0;
            while (value <= 1_000_000) {
                counter = value;
                value++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        });

        Thread print = new Thread(() -> {
            int value = 0;
            while (value <= 1_000_000) {
                System.out.println(counter);
                value++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        });
        count.start();
        print.start();
    }
}


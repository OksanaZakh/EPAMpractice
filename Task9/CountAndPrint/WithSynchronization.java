package Threads.CountAndPrint;

public class WithSynchronization {
    Number number;

    public void run() {
        number = new Number();
        Thread counter = new Thread(() -> {
            int value = 0;
            while (value <= 1_000_000) {
                number.increment(value);
                value++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        });
        Thread printer = new Thread(() -> {
            int value = 0;
            while (value <= 1_000_000) {
                number.print();
                value++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        });
        printer.start();
        counter.start();
    }

    class Number {
        int amount;
        boolean value = false;

        synchronized void print() {
            while (!value)
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            System.out.println(amount);
            value = false;
            notify();
        }

        synchronized void increment(int n) {
            while (value)
                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            amount = n;
            value = true;
            notify();
        }
    }
}

package Threads;

public class Bomb {
    public void runBomb() {
        Thread myThread=new Thread(() -> {
            for (int i = 10; i >= 0; i--) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.getMessage();
            }
        }
        System.out.println("Bomb!");
        });
        myThread.start();
    }
}

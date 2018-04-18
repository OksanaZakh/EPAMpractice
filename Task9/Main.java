package Threads;

import Threads.CountAndPrint.WithSynchronization;

public class Main {
    public static void main(String[] args) {
//        Bomb bomb=new Bomb();
//        bomb.runBomb();
//        WithoutSynchronization countAndPrint = new WithoutSynchronization();
//        countAndPrint.run();

        WithSynchronization withSynchronization =new WithSynchronization();
        withSynchronization.run();
    }
}

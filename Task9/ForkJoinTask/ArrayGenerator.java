package Threads.ForkJoinTask;

import java.util.Random;

public class ArrayGenerator {
    public static int[] generateIntArray() {
        Random random = new Random();
        int[] array = new int[1_000_000];
        for(int i=0; i<array.length; i++){
            array[i]=random.nextInt(100);
        }
        return array;
    }
}

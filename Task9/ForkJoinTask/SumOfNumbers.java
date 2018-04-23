package Threads.ForkJoinTask;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;


public class SumOfNumbers {
    private static int[] array;
    private static final int NUM_THREADS = 8;
    private static final int MAX_ARRAY_LENGTH = 20;

    public static void run() {
        array = ArrayGenerator.generateIntArray();
        ForkJoinPool pool = new ForkJoinPool(NUM_THREADS);
        int computedSum = pool.invoke(new RecursiveSum(array));
        System.out.println(computedSum);
        System.out.println(Arrays.stream(array).reduce((a, b) -> (a + b)).getAsInt());
    }

    static class RecursiveSum extends RecursiveTask<Integer> {
        int[] localArray;

        public RecursiveSum(int[] localArray) {
            this.localArray = localArray;
        }

        @Override
        protected Integer compute() {
            if (localArray.length <= MAX_ARRAY_LENGTH) {
                int locSum = 0;
                for (int i = 0; i < localArray.length; i++) {
                    locSum += localArray[i];
                }
                return locSum;
            } else {
                int mid = localArray.length / 2;
                RecursiveSum firstHalf = new RecursiveSum(Arrays.copyOfRange(localArray, 0, mid));
                firstHalf.fork();
                RecursiveSum secondHalf = new RecursiveSum(Arrays.copyOfRange(localArray, mid, localArray.length));
                int resultSecond = secondHalf.compute();
                return firstHalf.join() + resultSecond;
            }
        }
    }
}

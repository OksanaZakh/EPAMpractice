package Lambda;

import java.util.Arrays;
import java.util.Random;

public class RandomIntArray {
    public void runRandomArray() {
        Integer[] array = generateRandomIntArray(10);
        System.out.println("Random array");
        printArray(array);
        Arrays.sort(array, (a, b) -> b - a);
        System.out.println("Sorted random array");
        printArray(array);
        System.out.println("Modified int array:");
        array = makeModification(array, a -> a * a + 1);
        printArray(array);
    }

    private Integer[] generateRandomIntArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }
        return array;
    }

    private void printArray(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    @FunctionalInterface
    interface Modify {
        int makeModification(int x);
    }

    public Integer[] makeModification(Integer[] array, Modify modify) {
        Integer[] newArray = new Integer[array.length];
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 50) {
                newArray[i] = modify.makeModification(array[i]);
                count++;
            }
        }
        return Arrays.copyOf(newArray, count);
    }
}

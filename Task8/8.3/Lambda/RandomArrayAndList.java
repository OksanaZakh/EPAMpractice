package Lambda;

import java.util.*;

public class RandomArrayAndList {

    private final char[] ABC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'v', 'x', 'y', 'z'};

    private Integer[] array;
    private List<String> list;

    public void run() {
        array = generateRandomIntArray(10);
        System.out.println("Random array");
        printArray(array);
        Arrays.sort(array, (a, b) -> b - a);
        System.out.println("Sorted random array");
        printArray(array);
        System.out.println("Random list:");
        List<String> randomStringList=generateRandomStringList(10,5);
        System.out.println(randomStringList);
        System.out.println("Sorted random list:");
        Collections.sort(randomStringList, (a, b)-> -a.compareTo(b));
        System.out.println(randomStringList);
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

    private List<String> generateRandomStringList(int size, int strLength) {
        Random random=new Random();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String string="";
            for (int k=0; k<strLength; k++){
                string+=ABC[random.nextInt(20)];
            }
            stringList.add(string);
        }
        return stringList;
    }


}

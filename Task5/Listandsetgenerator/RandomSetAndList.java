package com.oksana.zakharchenko.listandsetgenerator;

import java.util.*;

public class RandomSetAndList {
//    public final String[] ABC = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
//            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

    private Random random;
    public static final String FAIL_LIST_GENERATE="Random list can not be generated with such arguments";
    public static final String FAIL_SET_GENERATE="Random set can not be generated with such arguments";

    public RandomSetAndList() {
        this.random = new Random();
    }

    public void run(int size, int from, int to) {
        try {
            generateRandomList(size, from, to);
        }catch (IllegalArgumentException e){
            System.out.println(FAIL_LIST_GENERATE);
        }
        try {
            generateRandomSet(size, from, to);
        }catch (IllegalArgumentException e){
            System.out.println(FAIL_SET_GENERATE);
        }
    }

    private void generateRandomList(int size, int from, int to) throws IllegalArgumentException {
        List<Integer> list = new ArrayList<>();
        if (to <= from || size > (to - from) || size <= 0 || from < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < size; i++) {
            int num = random.nextInt(to - from) + from;
            list.add(num);
        }
        System.out.println("Random list:");
        System.out.println(list);

    }

    private void generateRandomSet(int size, int from, int to) throws IllegalArgumentException {
        if (to <= from || size > (to - from) || size <= 0 || from < 0) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>();
        while (set.size() != size) {
            int num = random.nextInt(to - from) + from;
            set.add(num);
        }
        System.out.println("Random set:");
        System.out.println(set);

    }

//    public void run(int maxCollectionSize, int maxItemLength) {
//        generateRandomList(maxCollectionSize, maxItemLength);
//        generateRandomSet(maxCollectionSize, maxItemLength);
//    }
//
//    private String generateRandomString(int maxLength){
//        int randomNum=random.nextInt(maxLength);
//        String output="";
//        for (int i=0; i<randomNum; i++){
//            output=output+ABC[random.nextInt(26)];
//        }
//        return output;
//    }
//
//    private void generateRandomList(int maxCollectionSize, int maxItemLength){
//        List<String> list = new ArrayList<>();
//        int numStrings = random.nextInt(maxCollectionSize + 1);
//        for (int i = 0; i < numStrings; i++) {
//            list.add(generateRandomString(maxItemLength));
//        }
//        System.out.println("Random list:");
//        System.out.println(list);
//    }
//
//    private void generateRandomSet(int maxCollectionSize, int maxItemLength){
//        Set<String> set=new HashSet<>();
//        int numStrings = random.nextInt(maxCollectionSize + 1);
//        for (int i = 0; i < numStrings; i++) {
//            set.add(generateRandomString(maxItemLength));
//        }
//        System.out.println("Random set:");
//        System.out.println(set);
//    }

}

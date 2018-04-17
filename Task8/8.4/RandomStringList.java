package Lambda;

import java.util.*;

public class RandomStringList {

    private final char[] ABC = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'v', 'x', 'y', 'z'};

    public void runRandomStringList() {
        System.out.println("Random list:");
        List<String> randomStringList = generateRandomStringList(100, 5);
        System.out.println(randomStringList);
        System.out.println("Sorted random list:");
        Collections.sort(randomStringList, (a, b) -> -a.compareTo(b));
        System.out.println(randomStringList);
        System.out.println("Filtered sorted list:");
        System.out.println(filterList(randomStringList, s -> {
            if (s.charAt(0) == 'o') return s;
            else return "";
        }));
    }

    private List<String> generateRandomStringList(int size, int strLength) {
        Random random = new Random();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String string = "";
            for (int k = 0; k < strLength; k++) {
                string += ABC[random.nextInt(20)];
            }
            stringList.add(string);
        }
        return stringList;
    }

    @FunctionalInterface
    interface Filter {
        String makeFilter(String s);
    }

    private List<String> filterList(List<String> strings, Filter filter) {
        List<String> newStrings = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            if (!(filter.makeFilter(strings.get(i)).isEmpty())) {
                newStrings.add(strings.get(i));
            }
        }
        return newStrings;
    }
}

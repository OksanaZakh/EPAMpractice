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
        List<String> filteredList=filterList(randomStringList, s -> {
            if (s.charAt(0) == 'o') return s;
            else return "";
        });
        System.out.println(filteredList);
        System.out.println("Modified filtered and sorted list:");
//        System.out.println(modifyList(filteredList, s -> s.toUpperCase(), o -> {
//            if (o instanceof String) return true;
//            else return false;
//        }));
        System.out.println(modifyList(filteredList));
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

    private List<String> filterList(List<String> strings, FilterInterface filterInterface) {
        List<String> newStrings = new ArrayList<>();
        for (String string:strings) {
            if (!(filterInterface.makeFilter(string).isEmpty())) {
                newStrings.add(string);
            }
        }
        return newStrings;
    }

//    private List<String> modifyList(List<String> strings, ModifierInterface modifier, CheckInterface check) {
//        List<String> newStrings = new ArrayList<>();
//        for (String s : strings) {
//            if (check.isString(s)) {
//                newStrings.add(modifier.makeModification(s));
//            }
//        }
//        return newStrings;
  //  }
    private List<String> modifyList(List<String> strings) {
        List<String> newStrings = new ArrayList<>();
        for (String s : strings) {
            CheckInterface check= (Object o) -> o instanceof String;
            if (check.isString(s)) {
                ModifierInterface modifier= String::toUpperCase;
                newStrings.add(modifier.makeModification(s));
            }
        }
        return newStrings;
    }
    

    @FunctionalInterface
    interface FilterInterface {
        String makeFilter(String s);
    }

    @FunctionalInterface
    interface ModifierInterface {
        String makeModification(String s);
    }

    @FunctionalInterface
    interface CheckInterface {
        boolean isString(Object o);
    }
}


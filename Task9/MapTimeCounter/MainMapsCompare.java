package Threads.HashTimeCounter;

public class MainMapsCompare {
    public static void main(String[] args) {
        SimpleHasMap simpleHasMap =new SimpleHasMap(100, 20,10);
        simpleHasMap.runHashMap();
        ConcurrHashMap concurrHasMap=new ConcurrHashMap(100, 20,10);
        concurrHasMap.runConcurrHashMap();
        System.out.println("Simple HashMap results:");
        System.out.println("Writing average time: "+ simpleHasMap.getAverageWritingTime());
        System.out.println("Reading average time: "+ simpleHasMap.getAverageReadingTime());

        System.out.println("ConcurrentHashMapResults:");
        System.out.println("Writing average time: "+concurrHasMap.getAverageWritingTime());
        System.out.println("Reading average time: "+concurrHasMap.getAverageReadingTime());

//        Simple HashMap results:
//        Writing average time: 1.78
//        Reading average time: 252.96
//        ConcurrentHashMapResults:
//        Writing average time: 1.07
//        Reading average time: 260.96

    }
}

package Stream;

import Stream.PersonStream.PersonStream;

public class StreamMain {
    public static void main(String[] args) {
//            IntStream intStream=new IntStream();
//            intStream.run();
        PersonStream personStream=new PersonStream();
        personStream.run();
    }
}

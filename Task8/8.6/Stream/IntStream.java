package Stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntStream {
    public void run() {
        Stream<Integer> streamFromIterate = Stream.iterate(10, n -> n + 10);
        List<Integer> outputList = streamFromIterate.limit(10).map(n -> n / 2).collect(Collectors.toList());
        System.out.println(outputList);

    }
}

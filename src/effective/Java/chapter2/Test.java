package effective.Java.chapter2;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        // intermediate operation
        // distinct
        List<String> l = Stream.of("a","b","c","b")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(l);
        List<Integer> res = Arrays.asList(1, 1, 2, 2, 3, 4, 5);
        List<Integer> test = res.stream().distinct().collect(Collectors.toList());
        System.out.println(test.size());

        // filter
        List<Integer> filter = IntStream.range(1, 10)
                .filter(a -> a % 2 == 1)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(filter);

        //terminal operations
        //foreach
        Stream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        //min and max
        Stream.of(1, 2, 3, 4, 5).max((a, b) -> (a - b));




    }

}

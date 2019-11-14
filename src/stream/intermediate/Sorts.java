package stream.intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 정렬
 */
public class Sorts {

    public static void main(String[] args) {
        __testSort2();
    }


    /**
     * 문자열 리스트를 오름차순으로 정렬
     */
    private static void __testSort1() {
        List<String> fruitList = Arrays.asList("Banana", "Apple", "Pear", "Grape", "Melon");

        fruitList.stream().sorted((n1, n2) ->
                n1.compareTo(n2)).forEach(System.out::println);
    }

    private static void __testSort2() {
        List<String> fruitList =
                Arrays.asList("apple", "berry", "pear", "grape", "banana");

        fruitList
                .stream()
                .filter(s -> s.startsWith("b"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * 정렬 sort
     * Stream.sort 오름차순
     */
    private static void __testSort3() {
        //오른차순
        IntStream.of(20, 9, 5, 19, 2)
                .sorted()
                .forEach(System.out::println);


        //내림차순
        Stream.of(20, 9, 5, 19, 2)
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);


        //오른차순
        Stream.of(20, 9, 5, 19, 2)
                .sorted((o1, o2) -> (o1 < o2) ? -1 : (o1 == o2) ? 0 : 1)
                .forEach(System.out::println);

    }

    private static void __testSort4() {

        //오름차순 (메소드 레퍼런스)
        Stream.of("a", "abc", "ab", "abcd")
                .sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::println);

        //오름차순 (람다)
        Stream.of("a", "abc", "ab", "abcd")
                .sorted(Comparator.comparingInt(t -> t.length()))
                .forEach(System.out::println);

        //오름차순 (람다)
        Stream.of("a", "abc", "ab", "abcd")
                .sorted((t1, t2) -> (t1.length() < t2.length()) ? -1 : (t1.length() == t2.length()) ? 0 : 1)
                .forEach(System.out::println);

        //오름차순 (람다)
        Stream.of("a", "abc", "ab", "abcd")
                .sorted((t1, t2) -> Integer.compare(t1.length(), t2.length()))
                .forEach(System.out::println);
    }


}

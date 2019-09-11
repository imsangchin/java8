package stream.intermediate;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림내 자료들을 모두 하나로 합친 값을 만들어주는 역할
 * Reduce : accumulator (누산기, 축전지)
 *
 * ex)
 * int sum = integers.reduce(0, (a, b) -> a+b);
 */
public class Reduces {

    public static void main(String[] args) {
        __testReduce5();
    }

    /**
     * accumulator function
     */
    private static void __testReduce1() {
        int sum = IntStream.of(1, 2, 3, 4, 5).reduce(0, (n1, n2) -> n1 + n2);
        System.out.println(sum);
    }

    /**
     * 문자열 join
     */
    private static void __testReduce2() {
        Optional<String> joinedText = Stream.of("A", "B", "C", "D", "E").reduce((s1, s2) -> s1 + s2);
        if (joinedText.isPresent()) {
            System.out.println(joinedText.get());
        }
    }

    /**
     * 문자열 join
     */
    private static void __testReduce3() {
        Stream.of("A", "B", "C", "D", "E").reduce((s1, s2) -> s1 + s2).ifPresent(System.out::println);
    }

    /**
     * range + reduce 사용
     */
    private static void __testReduce4() {
        int value = IntStream.range(0, 4)
                .peek(System.out::println)
                .reduce(10, (n1, n2) -> n1 + n2);
        System.out.println(value); //16
    }

    /**
     * range + reduce 사용
     */
    private static void __testReduce5() {
        int value = Stream.of(1, 2, 3)
                .parallel()
                .peek(System.out::println)
                .reduce(10, // identity
                        Integer::sum);
        System.out.println(value);
    }


}

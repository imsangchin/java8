package stream.intermediate;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Calculate {

    public static void main(String[] args) {
        __testCalc6();
    }

    /**
     * 총합
     */
    private static void __testCalc1() {
        int sum = IntStream.of(1, 2, 3, 4, 5).sum();
        System.out.println("합계: " + sum);
    }

    /**
     * 요소의 개수
     */
    private static void __testCalc2() {
        long count = IntStream.of(1, 2, 3, 4, 5).count();
        System.out.println("개수: " + count);
    }

    /**
     * 최소값
     * OptionalInt: int 값을 보관하거나 보관하지 않을수 있는 컨테이너
     */
    private static void __testCalc3() {
        OptionalInt min = IntStream.of(1, 2, 3, 4, 5).min();
        if (min.isPresent()) {
            System.out.println("최소: " + min.getAsInt());
        }
    }

    /**
     * 최대값
     */
    private static void __testCalc4() {
        OptionalInt max = IntStream.of(1, 2, 3, 4, 5).max();
        if (max.isPresent()) {
            System.out.println("최대: " + max.getAsInt());
        }
    }

    /**
     * 평균값
     */
    private static void __testCalc5() {
        OptionalDouble average = IntStream.of(1, 2, 3, 4, 5).average();
        if (average.isPresent()) {
            System.out.println("평균: " + average.getAsDouble());
        }
    }

    /**
     * 평균값
     */
    private static void __testCalc6() {
        IntStream.of(1, 2, 3, 4, 5).average().ifPresent(System.out::println);
    }
}

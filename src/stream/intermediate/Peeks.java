package stream.intermediate;

import java.util.stream.IntStream;

/**
 * 스트림내 각 요소들에 대해서 특정 연산을 수행하며, (다른) 최종 스트림에서 실행됨
 * (보통 디버그 용도로 사용함)
 * peek 몰래 엿보다.
 */
public class Peeks {

    public static void main(String[] args) {
        __testPeek2();
    }

    private static void __testPeek1() {
        //아무런 출력이 없음
        IntStream.of(1, 2, 3, 4, 5).peek(System.out::println);

        // 총합
        IntStream.of(1, 2, 3, 4, 5).peek(System.out::println).sum();

        // 평균
        IntStream.of(10, 20, 30, 40, 50).peek(System.out::println).average();
    }

    /**
     * 다른 스트림 함수 사용시, 중간에 디버깅 용도로 사용함
     */
    private static void __testPeek2() {
        IntStream.of(1, 2, 3, 4)
                .filter(e -> e > 2)
                .peek(e -> System.out.println("필터된 값: " + e))
                .map(e -> e * e)
                .peek(e -> System.out.println("맵된 값: " + e))
                .sum();
    }

}

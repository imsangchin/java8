package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 스트림 vs 컬렉션
 * 1. collection: 자료구조를 구현해 놓은 구현체 (순차접근, ex) for, foreach ..)
 * <p>
 * 2. stream: 데이터 흐름, 자료구조를 다루는 역할 (병렬처리 지원)
 * 배열 또는 컬럭션에 여러 함수를 조합해서, (필터링 하거나, 가공해서) 원하는 결과를 얻어낼수 있다.
 * (컬렉션과 달리) 요소를 추가/삭제 하는게 불가능
 * <p>
 * 절차:
 * 생성 -> 가공 -> 필터링 -> 결과
 */
public class CreateStream1 {


    public static void main(String[] args) {
        __testStream13();
    }

    /**
     * 배열 스트림 생성
     * (Arrays.stream 사용)
     */
    private static void __testStream1() {
        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream = Arrays.stream(arr);

        stream.map(n -> n.toUpperCase()).forEach(str -> System.out.println(str));

        //한번 소비한 스트림은 재 사용 불가, 다시 스트림 생성
        stream = Arrays.stream(arr);
        //메소드 레퍼런스 사용
        stream.map(String::toUpperCase).forEach(str -> System.out.println(str));
    }


    /**
     * 리스트 스트림 생성
     * (컬렉션 타입(Collection, List, Set)의 경우 인터페이스에 추가된 디폴트 메소드 stream 을 이용)
     */
    private static void __testStream2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        list.stream()
                .filter(n -> (n % 2 == 0) ? true : false) // 짝수만 추출
                .forEach(
                        number -> System.out.println(number));
    }

    /**
     * 리스트 스트림 생성 -> 가공 -> 리스트 컬렉션 생성
     */
    private static void __testStream3() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddList = list.stream()
                .filter(n -> (n % 2 == 0) ? true : false) // 짝수만 추출
                .collect(Collectors.toList());

        oddList.stream().forEach(
                number -> System.out.println(number));

        // 참고: ArrayList안에 스트림에 보관중인 데이터를 저장한다.
        // List<String> asList = stringStream.collect(Collectors.toList());
    }

    /**
     * 스크림 생성
     * Stream.iterate 초기값과 해당 값을 다루는 람다를 이용해서 스트림 생성
     * Stream.iterate + UnaryOperator (functional interface)
     */
    private static void __testStream4() {
        Stream.iterate(1, n -> n + 1).limit(6).forEach(n ->
                System.out.println(n));
    }

    /**
     * 스트림 생성
     * Stream.generate + Supplier (functional interface)
     */
    private static void __testStream5() {
        Stream.generate(() -> "Hello!!").limit(5).forEach(text ->
                System.out.println(text));
    }


    /**
     * 스트림 빌더
     * Stream.builder + Supplier (functional interface)
     */
    private static void __testStream6() {
        Stream.<String>builder().add("A").add("B").add("C").add("D").build().
                forEach(System.out::println); // method reference
    }

    /**
     * 빈 스트림 생성
     */
    private static Stream __testStream7() {
        List list = new ArrayList();

        //보통 빈 스트림일때, null 대신 사용함
        Stream<String> stream;
        if (list == null || list.isEmpty()) {
            stream = Stream.empty();
        } else {
            stream = list.stream();
        }

        return stream;
    }

    /**
     * range를 통해 스트림 생성
     * (IntStream.range 사용)
     * @return
     */
    private static void __testStream8() {
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach(n -> System.out.println(n));

        // IntStream.range는 다음 형태
        // for (int i = startInclusive; i < endExclusive ; i++) { ... }
    }

    /**
     * range를 통해 스트림 생성
     * (IntStream.range 사용)
     * @return
     */
    private static void __testStream9() {
        IntStream intStream = IntStream.rangeClosed(1, 5);
        intStream.forEach(n -> System.out.println(n));

        // IntStream.range는 다음 형태
        // for (int i = startInclusive; i <= endInclusive ; i++) { ... }
    }

    /**
     * range를 통해 스트림 생성
     * (IntStream.range + boxed() 사용)
     * @return
     */
    private static void __testStream10() {
        Stream<Integer> intStream = IntStream.range(1, 5).boxed();
        intStream.forEach(n -> System.out.println(n));
    }

    /**
     * Random 클래스를 사용해서 스트림 생성
     * new Random().ints 사용
     */
    private static void __testStream11() {
        // 1(포함) ~ 10(제외) 중에서 랜덤한 정소를 3개 추출
        IntStream intStream = new Random().ints(3,1, 10);
        intStream.forEach(n -> System.out.println(n));
    }

    /**
     * 문자열 스트림
     */
    private static void __testStream12() {
        IntStream charsStream =
                "Coffee".chars();
        charsStream.forEach(n -> System.out.println( (char) n));
    }


    /**
     * Pattern.compile 이용한 스트림 생성
     */
    private static void __testStream13() {
        Stream<String> stream = Pattern.compile(",").splitAsStream("A, B, C");
        stream.forEach(text -> System.out.println(text));
    }
}

package stream.intermediate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 종료 메소드 중의 하나, 재사용시 IllegalStateException 발생함
 * 스트림내 자료들을 모두 하나로 합친 값을 만들어주는 역할, 보통 Collectors 클래스와 같이 쓰임
 * <p>
 * ( Java 8 streams can’t be reused.)
 */
public class Collects {

    public static void main(String[] args) {
        __testCollects1();
    }

    /**
     * 대문자로 변환후, 리스트로 반환한다.
     */
    private static void __testCollects1() {
        List<String> fruitList = Arrays.asList("Apple", "Banana", "Melon", "Grape", "Pear");
        List<String> upperCastList = fruitList.stream().map(text -> text.toUpperCase()).collect(Collectors.toList());
        upperCastList.forEach(System.out::println);
    }

    /**
     * 문자열 리스트를 묶어서 하나의 텍스트로 출력
     */
    private static void __testCollects2() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Melon", "Grape", "Strawberry"));

        Stream<String> stream = list.stream().map(String::toUpperCase);
        String text = stream.collect(Collectors.joining(","));
        System.out.println(text);

        // java.lang.IllegalStateException: stream has already been operated upon or closed
        text = stream.collect(Collectors.joining(","));
        System.out.println(text);
    }

    /**
     * 총 합 구하기
     * - collect + Collectors.summingInt
     */
    private static void __testCollects3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        int result = stream.collect(Collectors.summingInt(Integer::intValue));
        System.out.println(result);
    }

    /**
     * 입력 요소에 대해서, 지정한 수식을 수행후 정수값 들에 대한 요약 정보를 표시
     * - collect + Collectors.summarizingInt
     */
    private static void __testCollects4() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        IntSummaryStatistics result = stream.collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(result.toString());
    }

    /**
     * groupingBy 특정 조건으로 요소들을 그룹 지울수 있다.
     * - collect + Collectors.groupingBy
     */
    private static void __testCollects5() {
        Map map = Arrays.asList("a", "b", "aa", "bb", "c", "cc").stream().collect(
                Collectors.groupingBy( s -> s.length()));
        System.out.println(map.toString());
    }

}

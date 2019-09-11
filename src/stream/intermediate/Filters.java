package stream.intermediate;

import java.util.Arrays;
import java.util.List;

/**
 * 필터링
 */
public class Filters {
    public static void main(String[] args) {
        __testFilter1();
    }

    /**
     * 필터
     * Stream.filter + Predicate (functional interface)
     */
    private static void __testFilter1() {
        List<String> fruitList = Arrays.asList("Apple", "Banana", "Melon", "Grape", "Pear");
        fruitList.stream().filter(text -> text.contains("A")).forEach(
                System.out::println
        );
    }
}

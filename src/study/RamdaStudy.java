package study;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class RamdaStudy {
    public static void main(String[] args) {
        ConvertFunc<Integer, Integer> calc = (a, b) -> a + b;

        System.out.println(calc.convert(1, 2));

        BiConsumer<String, String> bc = (str1, str2) ->
                System.out.println(str1 + "," + str2);

        bc.accept("a", "b");

        Function<String, Integer> fu = str -> Integer.parseInt(str);
        int num = fu.apply("555");
        System.out.println(num);


        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);


        list.forEach( str -> System.out.println(str));
        list.forEach( System.out::println);

    }


    @FunctionalInterface
    interface ConvertFunc<T, R> {
        int convert(int a, int b);
    }

}

package lamda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * Function 사용예제
 * 하나의 인자를 받아서, 결과값을 리턴한다.
 */
public class Functions {

    public static void main(String[] args) {
        __testFunction6();
    }

    /**
     * Function 인터페이스 사용예
     * (정적 메서드 레퍼런스)
     */
    private static void __testFunction1() {
        Function<String, Integer> func = str -> Integer.parseInt(str);
        int value = func.apply("123");
        System.out.println(value);
    }

    /**
     * Function 인터페이스 사용예
     * (생성자 메서드 레퍼런스)
     */
    private static void __testFunction2() {
        Function<String, Integer> func = Integer::new;
        int value = func.apply("123");
        System.out.println(value);
    }

    /**
     * Function 인터페이스 사용예
     * (인자 인스턴스 메서드 레퍼런스)
     */
    private static void __testFunction3() {
        Function<Integer, Float> func = Integer::floatValue;
        float value = func.apply(123);
        System.out.println(value);
    }

    /**
     * Function 인터페이스 + 람다 이용 예제
     */
    private static void __textFunction4() {
        Function<String, List<Integer>> func = str -> {
            List<Integer> list = new ArrayList<>();
            String[] array = str.split(",");
            for (String s : array) {
                list.add(Integer.parseInt(s.trim()));
            }
            return list;
        };

        List<Integer> list = func.apply("1, 2, 3, 4, 5");
        System.out.println(list);
    }

    /**
     * BiFunction
     * 2개의 인자를 받아서, 결과값을 반환
     */
    private static void __testFunction5() {
        BiFunction<String, Integer, String> func = (text, repeat) -> {
            StringBuilder sb = new StringBuilder();
            for (int n = 0; n < repeat; n++) {
                sb.append(text);
                sb.append("\n");
            }
            return sb.toString();
        };

        System.out.println(func.apply("ABC", 3));
    }

    /**
     * IntToDoubleFunction
     * int 값을 받아서, double 값을 반환한다.
     */
    private static void __testFunction6() {
        // pie * r^2
        IntToDoubleFunction func = radius -> Math.PI * Math.pow(radius, 2);
        System.out.println( func.applyAsDouble(4));

    }
}

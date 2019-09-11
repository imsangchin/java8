package lamda;


import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Lamda 클래스
 */
public class Lamda {

    public static void main(String[] args) {
        __testLamda3();
    }

    /**
     * Int로 변환 시키는 함수
     */
    private static void __testLamda1() {
        ConvertIntFunction<String> func = new ConvertIntFunction<String>() {
            @Override
            public int convert(String value) {
                return Integer.parseInt(value);
            }
        };

        System.out.println(func.convert("100"));

        ConvertIntFunction<String> func2 = (s) -> {
            return Integer.parseInt(s);
        };
        System.out.println(func2.convert("100"));

        ConvertIntFunction<String> func3 = (s) -> Integer.parseInt(s);
        System.out.println(func3.convert("100"));
    }

    /**
     * Int로 변환 시키는 함수
     */
    private static void __testLamda2() {
        ConvertIntBiFunction<String, String> func = new ConvertIntBiFunction<String, String>() {
            @Override
            public int convertToIntValue(String value1, String value2) {
                return Integer.parseInt(value1) + Integer.parseInt(value2);
            }
        };
        System.out.println(func.convertToIntValue("1", "2"));

        ConvertIntBiFunction<String, String> func2 = (s1, s2) -> {
            return Integer.parseInt(s1) + Integer.parseInt(s2);
        };
        System.out.println(func2.convertToIntValue("1", "2"));

        ConvertIntBiFunction<String, String> func3 = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);
        System.out.println(func3.convertToIntValue("1", "2"));
    }

    /**
     * Int로 변환 시키는 함수 (메소드 레퍼런스)
     */
    private static void __testLamda3() {
        ConvertIntFunction<String> func = ConvertIntFunctionImpl::convert;
        System.out.println(func.convert("100"));
    }

}


@FunctionalInterface
interface ConvertIntFunction<T> {
    int convert(T value);
}

@FunctionalInterface
interface ConvertIntBiFunction<T, U> {
    int convertToIntValue(T value1, U value2);
}

class ConvertIntFunctionImpl {
    public static <T> int convert(T value) {
        String text = value.toString();
        return Integer.parseInt(text);
    }
}


package lamda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 메소드 레퍼런스 호출 예제
 */
public class CallMethodReference {

    public static void main(String[] args) {
    }

    /**
     * (해당인자) 클래스::인스턴스메소드 호출 방식
     * 해당 인자에 해당 하는 클래스의 메소드를 호춣
     */
    private static void __testCallMethodRef1() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);
        List<String> upperList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        upperList.forEach(System.out::println);
    }

    /**
     * 클래스::정적메소드 호출방식
     */
    private static void __testCallMethodRef2() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);
        List<String> upperList = list.stream().map(StringUtil::toUpperCase).collect(Collectors.toList());
        upperList.forEach(System.out::println);
    }

    /**
     * 객체::인스턴스메소드
     */
    private static void __testCallMethodRef3() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);
        List<String> upperList = list.stream().map(StringAccessory.instance::toUpperCase).collect(Collectors.toList());
        upperList.forEach(System.out::println);
    }
}


class StringUtil {
    static String toUpperCase(String s) {
        return s.toUpperCase();
    }
}

class StringAccessory {
    static StringAccessory instance = new StringAccessory();

    String toUpperCase(String s) {
        return s.toUpperCase();
    }
}


package lamda;

import java.util.function.*;

/**
 * Predicate 사용예
 * 하나의 인자를 받아서, boolean 값을 반환한다.
 * <p>
 * (Predicate 프로그래밍 번역서, "조건자", "서술자" 번역됨, 보통 bool 값을 반환하는 함수 객체...)
 */
public class Predicates {

    public static void main(String[] args) {
        __testPredicate5();
    }

    /**
     * Predicate 사용예
     */
    private static void __testPredicate1() {
        Predicate<String> p = text -> text.startsWith("A");

        if (p.test("Apple")) {
            System.out.println("Apple starts with A");
        }

        if (p.test("Banana")) {
            System.out.println("Banana starts with A");
        }
    }


    /**
     * BiPredicate 사용예
     */
    private static void __testPredicate2() {
        BiPredicate<String, String> p = (text, prefix) -> text.startsWith(prefix);

        if (p.test("Apple", "A")) {
            System.out.println("Apple starts with A");
        }

        if (p.test("Banana", "A")) {
            System.out.println("Banana starts with A");
        }
    }

    /**
     * DoublePredicate 사용예
     */
    private static void __testPredicate3() {
        DoublePredicate p = val -> val > 1.0 ? true : false;
        if (p.test(2)) {
            System.out.println("2 is over than 1.0");
        }

        if (p.test(0.9)) {
            System.out.println("0.9 is over than 1.0");
        }
    }

    /**
     * Predicate 사용예
     */
    private static void __testPredicate4() {
        IntPredicate p = val -> val > 10 ? true : false;
        if (p.test(2)) {
            System.out.println("2 is over than 10");
        }

        if (p.test(20)) {
            System.out.println("20 is over than 10");
        }
    }

    /**
     * Predicate 사용예
     */
    private static void __testPredicate5() {
        LongPredicate p = val -> val > 10L ? true : false;
        if (p.test(2L)) {
            System.out.println("2 is over than 10");
        }

        if (p.test(20L)) {
            System.out.println("20 is over than 10");
        }
    }
}



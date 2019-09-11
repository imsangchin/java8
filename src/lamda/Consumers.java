package lamda;

import java.util.function.*;

/**
 * 함수형 Consumers 인터페이스 사용예
 * <p>
 * 하나의 값을 입력받고, 리턴값은 없다.
 */
public class Consumers {

    public static void main(String[] args) {
        __testConsumer8();
    }

    /**
     * Consumers 사용예
     * (하나의 값을 받아서 처리)
     */
    private static void __testConsumer1() {
        Consumer<String> c = text -> System.out.println(text);
        c.accept("Hi");
    }

    /**
     * BiConsumer 사용예
     * (두개의 값을 받아서 처리)
     * 참고: Bi-Directional  (bidi, 양방향)
     */
    private static void __testConsumer2() {
        BiConsumer<String, String> c = (name, message) -> System.out.println(name + " " + message);
        c.accept("Java", "Welcome!!");
    }


    /**
     * DoubleConsumer 사용예
     */
    private static void __testConsumer3() {
        DoubleConsumer c = value -> System.out.println("double value is " + value);
        c.accept(3.14);
    }

    /**
     * IntConsumer 사용예
     */
    private static void __testConsumer4() {
        IntConsumer c = value -> System.out.println("int value is " + value);
        c.accept(123);
    }

    /**
     * LongConsumer 사용예
     */
    private static void __testConsumer5() {
        LongConsumer c = value -> System.out.println("long value is " + value);
        c.accept(Long.MAX_VALUE);
    }

    /**
     * ObjIntConsumer 사용예
     * (객체와 int 값을 인자로 받음)
     */
    private static void __testConsumer6() {
        ObjIntConsumer c = (obj, intval) -> System.out.println( obj.toString() + "->" + intval);
        c.accept("Coffee", 1000);
    }

    /**
     * ObjLongConsumer 사용예
     * (객체와 int 값을 인자로 받음)
     */
    private static void __testConsumer7() {
        ObjLongConsumer c = (obj, longval) -> System.out.println( obj.toString() + "->" + longval);
        c.accept("ID", Long.MAX_VALUE);
    }

    /**
     * ObjDoubleConsumer 사용예
     * (객체와 double 값을 인자로 받음)
     */
    private static void __testConsumer8() {
        ObjDoubleConsumer c = (obj, doubleval) -> System.out.println( obj.toString() + "->" + doubleval);
        c.accept("Pie", Math.PI);
    }

}

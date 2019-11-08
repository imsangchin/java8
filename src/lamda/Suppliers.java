package lamda;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;

/**
 * 함수형 Supplier 인터페이스 사용예
 *
 * 입력값이 없으며, 리턴값만 존재한다.
 */
public class Suppliers {

    public static void main(String[] args) {
        __testSupplier3();
    }

    /**
     * 단순히 텍스트 출력
     */
    private static void __testSupplier1() {
        Supplier<String> s = () -> "Hello World";
        System.out.println(s.get());
    }

    /**
     * 랜덤함수
     */
    private static void __testSupplier2() {
        Supplier<Integer> s = () -> new Random().nextInt(10);
        System.out.println(s.get());
    }

    /**
     * IntSupplier 사용예
     * 랜덤함수
     * Int 값을 리턴하는 Supplier
     */
    private static void __testSupplier3() {
        IntSupplier s = () -> new Random().nextInt(10);
        System.out.println(s.getAsInt());
    }
}

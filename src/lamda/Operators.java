package lamda;

import java.util.Comparator;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.UnaryOperator;

/**
 * Operator 사용예
 * 인자를 받아서, 값을 반환한다.
 */
public class Operators {

    public static void main(String[] args) {
        __testOperator5();
    }

    /**
     * BinaryOperator 사용예
     * 동일한 타입의 2개의 인자를 받아서, 동일한 타입의 결과값을 반환
     */
    private static void __testOperator1() {
        BinaryOperator<Integer> sumOp = (n1, n2) -> n1 + n2;

        System.out.println(sumOp.apply(10, 20));
    }

    /**
     * BinaryOperator.minBy 사용예
     */
    private static void __testOperator2() {
        BinaryOperator minOper = BinaryOperator.minBy(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1);
            }
        });

        System.out.println(minOper.apply(10, 20));
    }

    /**
     * BinaryOperator.minBy 사용예
     */
    private static void __testOperator3() {
        BinaryOperator<Integer> minOper = BinaryOperator.minBy
                ((o1, o2) -> (o1 < o2) ? -1 : ((o1 == o2) ? 0 : 1));
        System.out.println(minOper.apply(10, 20));
    }

    /**
     * UnaryOperator 사용예
     * 하나의 인자를 받아서, 동일한 타입의 결과값을 반환
     */
    private static void __testOperator4() {
        UnaryOperator<Integer> oper  = (n) -> n * n;

        System.out.println(oper.apply(10));
    }

    /**
     * IntBinaryOperator 사용예
     * 2개의 int값을 받아서, int 값을 반환
     */
    private static void __testOperator5() {
        IntBinaryOperator oper  = (n1, n2) -> n1 * n2;
        System.out.println(oper.applyAsInt(10, 2));
    }

}

package lamda;


public class CreateFunInterface {
    private void testCalculate() {
        double value1= WmpCalculator.add(2, 3,
                (n1, n2) -> (n1 + n2) * 0.9);
    }

    static class WmpCalculator {
        private static <T, R> R add(T n1, T n2, PlusOperator<T, R> operator) {
            return operator.plus(n1, n2);
        }
    }

    @FunctionalInterface
    interface PlusOperator<T, R> {
        R plus(T n1, T n2);
    }
}

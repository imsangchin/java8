package lamda;

/**
 * 함수형 Runnable 인터페이스 사용예
 *
 */
public class Runnables {

    public static void main(String[] args) {
        __testRunnable();
    }

    private static void __testRunnable() {
        Runnable r = () -> {
            System.out.println("Runnable");
        };
        r.run();
    }
}

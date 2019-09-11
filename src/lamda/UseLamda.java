package lamda;

/**
 * 1. 람다 사용에 대한 간단한 예제
 * 2. Functional Interface 사용 예제
 *
 * 정의: 람다식 이란? 식별자 없이 실행할 수 있는 함수 표현식을 의미하며, 익명 함수(anonymous function)라고도 함
 * why? 익명 클래스를 작성할때 사용되는 반복적이고 지저분한 코드를 줄여서, 코드의 가독성을 높인다.
 */
public class UseLamda {
    public static void main(String[] args) {
    }

    private void __testSum1() {
        CalcSum sum = new CalcSum() {
            @Override
            public int calc(int a, int b) {
                return a + b;
            }
        };

        int value = sum.calc(10, 20);
        System.out.println("sum =" + value);
    }

    /**
     * 람다식으로 구현
     * (자료형) -> { 구현내용; return 결과값; }
     */
    private void __testSum2() {
        CalcSum sum = (int a, int b) -> {
            return a + b;
        };

        int value = sum.calc(10, 20);
        System.out.println("sum =" + value);
    }

    /**
     * 1. 매개변수의 타입을 추론할 수 있는 경우에는 타입을 생략할 수 있습니다.
     * 2. 함수의 몸체가 하나의 return 문으로만 이루어진 경우에는 중괄호({})를 생략할 수 없습니다.
     * 3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있습니다.
     * <p>
     * (자료형) -> 결과값;
     */
    private void __testSum3() {
        CalcSum sum = (a, b) -> a + b;

        int value = sum.calc(10, 20);
        System.out.println("sum =" + value);
    }

    /**
     * Generic을 사용해서 여러 자료형에 적용할수 있다.
     */
    private void __testSum4() {
        CaclSumGeneric<Float> sum = (a, b) -> a + b;

        float value = sum.calc(10f, 20f);
        System.out.println("sum =" + value);
    }

    /**
     * (전통방식의) 쓰레드 실행
     */
    private void __testThread1() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread run");
            }
        });
        th.start();
    }

    /**
     * (람다식) 쓰레드 실행
     */
    private void __testThread2() {
        Thread th = new Thread(() -> System.out.println("Thread run"));
        th.start();
    }

    /**
     * (람다식) 쓰레드 실행
     */
    private void __testThread3() {
        Runnable runnable = () -> {
            System.out.println("Thread run");
        };
        Thread th = new Thread(runnable);
        th.start();
    }

    /**
     * (람다식) 쓰레드 실행
     * 3. 함수의 몸체가 하나의 명령문만으로 이루어진 경우에는 중괄호({})를 생략할 수 있습니다.
     */
    private void __testThread4() {
        Runnable runnable = () -> System.out.println("Thread run");
        Thread th = new Thread(runnable);
        th.start();
    }
}

/**
 * @FunctionalInterface 사용하면, (컴파일러는) 해당 인터페이스를 함수형 인터페이스로 인식
 * 단, 하나의 추상메소드만 허용한다.
 */
@FunctionalInterface
interface CalcSum {
    int calc(int a, int b);
}

@FunctionalInterface
interface CaclSumGeneric<T> {
    T calc(T a, T b);
}


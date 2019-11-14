package stream.intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * 병렬 처리
 * ExecutorService
 */
public class Parallels {
    public static void main(String[] args) {
        __testParallel7();
    }

    /**
     * 쓰레드 풀을 사용한 연산 처리
     */
    private static void __testParallel1() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.submit(() -> {
                System.out.println( "index= " + index + ", 쓰레드 " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 쓰레드 풀을 사용한 연산 처리
     * ForkJoinPool? Java7부터 사용가능한 Java Concurrency 툴이며, 동일한 작업을 여러개의 Sub Task로 분리(Fork)하여 각각 처리하고,
     * 이를 최종적으로 합쳐서(Join) 결과를 만들어내는 방식이다.
     *
     */
    private static void __testParallel() {

        ForkJoinPool pool = new ForkJoinPool();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            pool.execute(() -> {
                System.out.println( "index= " + index + ", 쓰레드 " + Thread.currentThread().getName());
            });
        }

        pool.awaitQuiescence(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }


    /**
     * Stream.parallel을 사용해서 병렬 연산 처리 수행
     * (내부적으로 ForkJoinPool)
     */
    private static void __testParallel3() {
        IntStream.range(0, 10).parallel().forEach(index ->
                System.out.println( "index= " + index + ", 쓰레드 " + Thread.currentThread().getName()));
    }

    /**
     * parallelStream() 를 사용해서, (손쉽게) 병렬 스크림 생성
     */
    private static void __testParallel4() {
        Arrays.asList("a", "b", "c").parallelStream().forEach(index ->
                System.out.println( "index= " + index + ", 쓰레드 " + Thread.currentThread().getName()));
    }


    private static void __testParallel5() {
        int reducedParallel = Arrays.asList(1, 2, 3).stream()
                .reduce(10, (a, b) -> {
                    System.out.println( String.format("%d + %d ", a, b) + ", 쓰레드 " + Thread.currentThread().getName() );
                    return a + b;
                });
        System.out.println("reducedParallel=" + reducedParallel);
    }

    private static void __testParallel6() {
        int reducedParallel = Arrays.asList(1, 2, 3).stream()
                .reduce(10, (a, b) -> {
                    System.out.println( String.format("%d + %d ", a, b) + ", 쓰레드 " + Thread.currentThread().getName() );
                    return a + b;
                });
        System.out.println("reducedParallel=" + reducedParallel);
    }

    /**
     * (병렬방식)
     * 1에서 100,000 까지 소수를 찾아서 모두 더하시요.
     */
    private static void __testParallel7() {
        long startTime = System.currentTimeMillis();

        int total = IntStream.rangeClosed(1, 100000).parallel().filter( n -> {
            boolean isPrime = true;
            for (int i = 2; i < n; i++) {
                if( n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            return n > 1 && isPrime;
        }).reduce( (a, b) -> a+b).getAsInt();

        System.out.println("consume time=" + (System.currentTimeMillis() - startTime) );
        System.out.println("total=" + total);
    }

    /**
     * 메인 쓰레드 실행 방식
     * 1에서 100,000 까지 소수를 찾아서 모두 더하시요.
     */
    private static void __testParallel8() {
        long startTime = System.currentTimeMillis();

        int total = IntStream.rangeClosed(1, 100000).filter( n -> {
            boolean isPrime = true;
            for (int i = 2; i < n; i++) {
                if( n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            return n > 1 && isPrime;
        }).reduce( (a, b) -> a+b).getAsInt();

        System.out.println("consume time=" + (System.currentTimeMillis() - startTime) );
        System.out.println("total=" + total);
    }

}

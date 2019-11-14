package stream.intermediate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map, flatmap 사용예
 */
public class Maps {
    public static void main(String[] args) {
        _testFlatMap();
    }


    /**
     * 매핑
     * Stream.map + Function (functional interface)
     * 스트림내 항목들을 특정 값으로 변환시킴
     */
    private static void __testMap1() {
        List<String> fruitList = Arrays.asList("Apple", "Banana", "Melon", "Grape", "Pear");
        fruitList.stream().map(text -> text.toUpperCase()).forEach(
                System.out::println
        );

        fruitList.stream().map(String::toLowerCase).forEach(
                System.out::println
        );
    }

    /**
     * 매핑
     * Stream.mapToInt + Function (functional interface)
     */
    private static void __testMap2() {

        List<Student> studentList = Arrays.asList(Student.newInstance("Kim", 90, 100, 80),
                Student.newInstance("Lee", 100, 80, 60),
                Student.newInstance("Park", 100, 100, 100)
        );

        //국어 평균
        studentList.stream()
                .mapToInt(student ->
                        student.korScore
                )
                .average().ifPresent(averge ->
                System.out.println("평균=" + averge)
        );
    }

    /**
     * Stream.flatmap + Function (functional interface)
     * <p>
     * 중첩된 리스트를 단일 리스트로 전환
     */
    private static void __testMap3() {
        List<List<String>> list =
                Arrays.asList(Arrays.asList("a1", "a2", "a3"),
                        Arrays.asList("b1", "b2", "b3"));

        List<String> flatList =
                list.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
        flatList.forEach(
                System.out::println
        );
    }

    /**
     * Stream.flatmap + Function (functional interface) + reduce 사용예
     * <p>
     * 중첩된 리스트를 단일 리스트로 전환
     */
    private static void __testMap4() {

        List<Customer> customerList = new ArrayList<>();
        Customer kim = new Customer("Kim");
        kim.buy(10);
        kim.buy(20);

        Customer lee = new Customer("Lee");
        lee.buy(30);
        lee.buy(30);

        customerList.add(kim);
        customerList.add(lee);

        int total = customerList.stream()
                .flatMap(customer ->
                        customer.paymentList.stream())
                .reduce(0, (n1, n2) -> n1 + n2);

        // Integer sum = integers.reduce(0, (a, b) -> a+b);
        System.out.println("합계:" + total);
    }

    private static void _testFlatMap() {
        String[] strArr1 = {"A", "B", "C"};
        String[] strArr2 = {"D", "E", "F"};

        String[] mergedArr = Stream.of(strArr1, strArr2).flatMap(s -> Stream.of(s)).toArray(String[]::new);
        System.out.println(Arrays.toString(mergedArr));
    }
}


class Student {
    String name;
    int korScore;
    int engScore;
    int mathScore;

    private Student(String name, int korScore, int engScore, int mathScore) {
        this.name = name;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;
    }

    public static Student newInstance(String name, int korScore, int engScore, int mathScore) {
        return new Student(name, korScore, engScore, mathScore);
    }
}

class Customer {
    String name;
    List<Integer> paymentList;

    Customer(String name) {
        this.name = name;
        this.paymentList = new ArrayList<>();
    }

    void buy(int price) {
        paymentList.add(price);
    }
}
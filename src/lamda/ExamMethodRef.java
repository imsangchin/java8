package lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 간단한 메소드 레퍼런스 사용예제
 */
public class ExamMethodRef {

    public static void main(String[] args) {
        ExamMethodRef.__testMethodReference3();
    }

    public static void sortWithMethodRef() {
        String[] strings = {"C", "d", "a", "B", "e"};
        List<String> list = Arrays.asList(strings);
        // 리스트를 대소문자 구분없이 정렬하도록, 아래 내용을 채우세요.
        list.sort(String::compareToIgnoreCase);
        list.forEach(System.out::println);
    }


    /**
     * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * 제곱값이 50보다 큰 수 찾기
     *
     * @param number
     * @param power
     * @return
     */
    static boolean isPowerMoreThan100(int number, int power) {
        return Math.pow(number, power) > 50;
    }

    /**
     * BiPredicate를 사용해서, 리스트내 조건에 만족하는 요소 구하기
     *
     * @param list
     * @param p
     * @return
     */
    private static List<Integer> __findNumbers(List<Integer> list, BiPredicate<Integer, Integer> p) {
        List<Integer> foundList = new ArrayList<>();
        for (Integer i : list) {
            if (p.test(i, 2)) {
                foundList.add(i);
            }
        }
        return foundList;
    }

    /**
     * Static method reference 사용예제
     */
    private static void __testMethodReference1() {
        List<Integer> list = Arrays.asList(4, 5, 6, 7, 8, 9, 10);
        //익명 클래스 이용
        List<Integer> newList1 = __findNumbers(list, new BiPredicate<Integer, Integer>() {
            @Override
            public boolean test(Integer n1, Integer n2) {
                return isPowerMoreThan100(n1, n2);
            }
        });
        System.out.println(newList1.stream().map(String::valueOf).collect(Collectors.joining(",")));

        // 람다
        List<Integer> newList2 = __findNumbers(list, (n1, n2) -> isPowerMoreThan100(n1, n2));
        System.out.println(newList2.stream().map(String::valueOf).collect(Collectors.joining(",")));

        // 메소드 레퍼런스
        List<Integer> newList3 = __findNumbers(list, ExamMethodRef::isPowerMoreThan100);
        System.out.println(newList3.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    /**
     * 카트에 담을 상품
     */
    static class ShopItem {
        int id;
        String name;

        ShopItem(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    /**
     * 고객
     */
    static class Customer {
        void cart(ShopItem item) {
            System.out.println(item.name + "을 카트에 담았습니다.");
        }
    }

    /**
     * 고객 액
     * @param item
     * @param c
     */
    static void userAction(ShopItem item, Consumer<ShopItem> c) {
        c.accept(item);
    }

    /**
     * Instance method reference 사용예제
     */
    static void __testMethodReference2() {
        Customer customer = new Customer();
        ShopItem item = new ShopItem(100, "커피");

        //익명 클래스 이용
        userAction(item, new Consumer<ShopItem>() {
            @Override
            public void accept(ShopItem shopItem) {
                customer.cart(shopItem);
            }
        });

        // 람다
        userAction(item, si -> customer.cart(si));
        // 메소드 레퍼런스
        userAction(item, customer::cart);
    }

    /**
     * BMP vo
     */
    static class Bmi {
        int height;
        int weight;

        Bmi(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        /**
         * 몸무게(kg) ÷ (신장(m) × 신장(m))
         *
         * @return
         */
        public double calcBmi() {
            double result = weight / (double) (height * height);
            System.out.println("BMI = " + result);
            return result;
        }
    }

    /**
     * 리스트내 항목에 대해서 BMP 계산을 수행
     * @param list
     * @param func
     * @return
     */
    static List<Double> calculateBmi(List<Bmi> list, Function<Bmi, Double> func) {
        List<Double> resultList = new ArrayList<>();
        for (Bmi bmi : list) {
            resultList.add(func.apply(bmi));
        }
        return resultList;
    }

    /**
     * (일반메소드에 대한) Instance method reference 사용예제
     */
    static void __testMethodReference3() {
        List<Bmi> l = new ArrayList<>();
        l.add(new Bmi(100, 30));
        l.add(new Bmi(150, 50));
        l.add(new Bmi(200, 100));

        //익명 클래스 이용
        calculateBmi(l, new Function<Bmi, Double>() {
            @Override
            public Double apply(Bmi bmi) {
                return bmi.calcBmi();
            }
        });

        // 람다
        calculateBmi(l, bmi -> bmi.calcBmi());
        // 메소드 레퍼런스
        calculateBmi(l, Bmi::calcBmi);
    }

}

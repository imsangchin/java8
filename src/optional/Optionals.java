package optional;

import java.util.Optional;

/**
 * https://www.mkyong.com/java8/java-8-optional-in-depth/
 * https://advenoh.tistory.com/15
 */
public class Optionals {

    public static void main(String[] args) {
        __testOptional7();
    }

    /**
     * Optional.empty()는 값이 존재하지 않는 Optional 객체를 의미한다.
     */
    private static void __testOptional1() {
        Optional<String> empty =  Optional.empty();
        System.out.println(empty);

        if( empty.isPresent()) {
            System.out.println("Present");
        }else {
            System.out.println("Absent");
        }
    }

    /**
     * Optional.of()는 널이 아닌 객체를 보관하는 Optional 객체생성
     * (널을 담을수는 없다.)
     */
    private static void __testOptional2() {
        Optional<String> fruitOpt = Optional.of("Apple");

        if( fruitOpt.isPresent()) {
            // get() 를 사용해서, 값에 접근 한다.
            System.out.println(fruitOpt.get());
        }else {
            System.out.println("Absent");
        }

        String nullObject = null;
        fruitOpt = Optional.of(nullObject); // 여기에서, java.lang.NullPointerException 예외 발생
    }

    /**
     * Optional.ofNullable()는 널인 객체를 담을수 있는 Optional 객체생성
     */
    private static void __testOptional3() {
        Optional<String> fruitOpt = Optional.ofNullable(null);
        if( fruitOpt.isPresent()) {
            // get() 를 사용해서, 값에 접근 한다.
            System.out.println(fruitOpt.get());
        }else {
            System.out.println("Absent");
        }
    }

    /**
     * ifPresent(함수) 형태로, 널이 아닌 경우 함수를 실행한다.
     */
    private static void __testOptional4() {
        Optional<String> fruitOpt = Optional.of("Apple");
        fruitOpt.ifPresent(name -> System.out.println(name));
    }

    /**
     * orElse(기본값) 형태로, 널인 경우 기본값을 사용한다.
     */
    private static void __testOptional5() {
        Optional<String> fruitOpt = Optional.ofNullable(null);
        String fruit = fruitOpt.orElse("Banana");
        System.out.println(fruit);
    }

    /**
     * orElseGet(함수) 형태로, 널인 경우 함수 결과값을 사용한다.
     */
    private static void __testOptional6() {
        Optional<String> fruitOpt = Optional.ofNullable(null);
        String fruit1 = fruitOpt.orElseGet(() -> "Banana"); //람다 사용
        String fruit2 = fruitOpt.orElseGet(Optionals::__returnString); //메소드 레퍼런스 사용

        System.out.println(fruit1);
        System.out.println(fruit2);
    }

    private static String __returnString() {
        return "Orange";
    }


    /**
     * orElseGet(함수) 형태로, 널인 경우 함수 결과값을 사용한다.
     */
    private static void __testOptional7() {
        Optional<String> fruitOpt = Optional.ofNullable(null);
        String fruit1 = fruitOpt.orElseGet(() -> "Banana"); //람다 사용
        String fruit2 = fruitOpt.orElseGet(Optionals::__returnString); //메소드 레퍼런스 사용

        System.out.println(fruit1);
        System.out.println(fruit2);
    }

    private static void __testOptional8() throws IllegalAccessException {
        Optional<String> fruitOpt = Optional.ofNullable(null);
        fruitOpt.orElseThrow(IllegalAccessException::new);
    }
}

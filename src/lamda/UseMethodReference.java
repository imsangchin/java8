package lamda;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Method Reference 예제
 *
 * why? 자바에서 메소드는 1급 객체가 아니므로, 1급 함수를 메소드 레퍼런스 방식으로 구현.
 * 메소드 인자에 람다식을 전달하기 위한 방법으로 "메소드 레퍼런스" 방식 사용
 *
 * 1. 일급객체 (first class object): 객체를 1급 시민으로 취급
 * 2. 일급함수 (first class function): 함수를 1급 시민으로 취급
 *  ex) val helloFunPtr: () -> String = {"hello world"}
 *      print( helloFunPtr() )
 * 3. 일급시민: 다음 조건을 만족해야 한다.
 *     - 변수(variable)에 담을 수 있다
 *     - 함수 인자(parameter)로 전달할 수 있다
 *     - 함수 반환값(return value)으로 전달할 수 있다
 *
 * 4. 고차함수:  (c언어는 고차함수를 지원한다.) 함수를 함수의 인자로 받을수 있다. 함수를 결과값으로 리턴할수 있다.
 */
public class UseMethodReference {

    public static void main(String[] args) {

    }

    /**
     * (전통적인 방식) 리스트내 항목에 접근
     */
    private void __testMethodRef1() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);

        for( String text: list) {
            System.out.println(text);
        }
    }

    /**
     * forEach 사용
     */
    private void __testMethodRef2() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String text) {
                System.out.println(text);
            }
        });
    }

    /**
     * forEach + 람다 사용
     * (람다식을 사용해서, Consumer 인터페이스내 accept 메소드를 구현한 방식 사용함.
     *  구현한 Consumer.accept 메소드에서 -> 익명함수 호출하는 방식)
     */
    private void __testMethodRef3() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);

        list.forEach(text -> System.out.println(text));
    }

    /**
     * forEach + 메소드 레퍼런스 사용
     * (메소드 레퍼런스 사용, 실행해야 할 메소드를 바로 지정)
     *
     * 형태:
     * 1. 클래스::(public)인스턴스메소드
     * 2. 클래스::(static)정적메소드
     * 3. 객체::인스턴스메소드(new)
     */
    private void __testMethodRef4() {
        String[] strings = {"a", "b", "c", "d", "e"};
        List<String> list = Arrays.asList(strings);

        list.forEach(System.out::println);
    }

}

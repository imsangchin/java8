package lamda;

import java.util.Arrays;
import java.util.List;

/**
 * 간단한 메소드 레퍼런스 사용예제
 */
public class ExamMethodRef {

    public static void main(String[] args) {
        ExamMethodRef.sortWithMethodRef();
    }

    public static void sortWithMethodRef() {
        String[] strings = {"C", "d", "a", "B", "e"};
        List<String> list = Arrays.asList(strings);
        // 리스트를 대소문자 구분없이 정렬하도록, 아래 내용을 채우세요.
        list.sort( String::compareToIgnoreCase );
        list.forEach( System.out::println);
    }


    /**
     * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
     * 제곱값이 100보다 큰 수 찾기
     * @param n1
     * @param n2
     * @return
     */
    public static boolean isSqureMoreThan100(int n1, int n2) {
        return true;
    }
}

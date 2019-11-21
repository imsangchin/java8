package definterface;

import java.util.*;

public class MultipleInterfaces {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(5, 2, 4, 2, 1);
        Collections.sort(intList, (a, b) -> a.compareTo(b));

        List<String> strList = Arrays.asList("Red", "Green", "Blue");
        Collections.sort(strList, (a, b) -> a.compareTo(b));
    }

    static <T> List<T> add(List<T> list, T a, T b) {
        list.add(a);
        list.add(b);
        return list;
    }


    interface WinterSale {
        default void discount() {
            System.out.println("10% 할인");
        }
    }

    interface BlackFriSale {
        default void discount() {
            System.out.println("15% 할인");
        }
    }

    /**
     * 다중 인터페이스에 동일한 기본 메소드가 정의 되어 있는 경우
     */
    class Sale implements WinterSale, BlackFriSale {
        boolean mIsVipUser = false;

        /**
         * super 키워드를 사용해서, 원하는 인터페이스내 기본 메소드 호출 가능
         */
        @Override
        public void discount() {
            // Vip 사용자는 블프 세일 할인을 적용한다.
            if( mIsVipUser) {
                BlackFriSale.super.discount();
            }else {
                WinterSale.super.discount();
            }
        }
    }
}

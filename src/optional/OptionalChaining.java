package optional;

import java.util.Date;
import java.util.Optional;

public class OptionalChaining {

    public static void main(String[] args) {
        // System.out.println(getCityOfMemberFromOrder2(null));

        System.out.println(isStringNotNull("a"));
        System.out.println(isStringNotNull(null));
        System.out.println(isStringNotNull(""));
        System.out.println(isStringNotNull("abc"));
    }

    /**
     * 주문
     */
    static class Order {
        private Long id;
        private Date date;
        private Member member;

        public Member getMember() {
            return member;
        }
    }

    /**
     * 회원
     */
    static class Member {
        private Long id;
        private String name;
        private Address address;

        public Address getAddress() {
            return address;
        }
    }

    /**
     * 주소
     */
    static class Address {
        private String street;
        private String city;
        private String zipcode;

        public String getCity() {
            return city;
        }
    }

    /**
     * 주문을 한 회원이 살고 있는 도시 정보를 반환
     * @param order
     * @return
     */
    public static String getCityOfMemberFromOrder(Order order) {
        if (order != null) {
            Member member = order.getMember();
            if (member != null) {
                Address address = order.getMember().getAddress();
                if (address != null) {
                    String city = address.getCity();
                    if( city != null) {
                        return city;
                    }
                }
            }
        }
        return "서울";
    }

    /**
     * Optional을 사용한 NPE 피하기
     * @param order
     * @return
     */
    public static String getCityOfMemberFromOrder2(Order order) {
        return Optional.ofNullable(order)
                .map(Order::getMember)
                .map(Member::getAddress)
                .map(Address::getCity)
                .orElse("서울");
    }

    /**
     * text 가 널이 아니고, 길이가 0보다 크면 true를 리턴
     * @param text
     * @return
     */
    public static boolean isStringNotNull(String text) {
        return Optional.ofNullable(text).map(String::length).orElse(0).intValue() > 0;
    }
}

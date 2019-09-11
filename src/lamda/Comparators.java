package lamda;

import java.util.Comparator;

/**
 * Comparator 사용예
 * 람다를 사용해서, 매우 간결하게 구현 가능
 */
public class Comparators {

    public static void main(String[] args) {
        __testComparator();
    }

    private static void __testComparator() {
        Comparator<Member> c = (o1, o2) -> (o1.id < o2.id) ? -1 : ((o1.id == o2.id) ? 0 : 1);
        int result = c.compare(new Member(1, "ABC"),
                new Member(2, "DEF"));

        System.out.println("result=" + result);
    }

    static class Member {
        String name;
        int id;

        public Member(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

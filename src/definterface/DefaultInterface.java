package definterface;

public class DefaultInterface {

    public static void main(String[] args) {
        Pig pig = new Pig();
        pig.lengthOfLeg();

        Animal.sleep();
    }

    interface Animal {
        void eat();

        static void sleep() {
            System.out.println("zzz");
        }

        /**
         * 기본 메소드
         * @return
         */
        default int lengthOfLeg() {
            return 4;
        }
    }

    static class Pig implements Animal {
        @Override
        public void eat() {
            System.out.println("잡식");
        }
    }

    static class Rabbit implements Animal {
        @Override
        public void eat() {
            System.out.println("당근");
        }
    }

    class Eagle implements Animal {
        /**
         * 기본 메소드를 오버라이딩 할수 있다.
         * @return
         */
        @Override
        public int lengthOfLeg() {
            return 2;
        }
        @Override
        public void eat() {
            System.out.println("작은새");
        }
    }


}

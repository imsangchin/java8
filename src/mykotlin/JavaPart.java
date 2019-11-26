package mykotlin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JavaPart {

    public static void main(String[] args) {
        __testException();
    }

    private static void __testException() {
        File file = new File(System.getProperty("user.dir"));
        try {
            FileInputStream fin = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(file);

        useThread();
    }

    int sum(int a, int b) {
        return a + b;
    }

    /**
     * 간단한 쓰레드 사용예
     */
    static void useThread() {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int n = 0; n < 10; n++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(n + ">" + "난 쓰레드에서 동작중");
                }
            }
        });
        th.start();
        try {
            th.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class Book {
        private String title;
        private int price;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }
}


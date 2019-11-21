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
    }

}

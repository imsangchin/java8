package stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CreateStream2 {
    public static void main(String[] args) {
        __testStream2();
    }

    /**
     * 파일 스트림 (Files.lines 사용해서, 한줄씩 읽기)
     */
    private static void __testStream1() {
        File file = new File(".", "파일.txt");

        //try with resources
        try (Stream<String> stream = Files.lines(Paths.get(file.toURI()), Charset.forName("UTF-8"))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 스트림 연결
     * (Stream.concat)
     */
    private static void __testStream2() {
        Stream<String> stream1 = Stream.of("A", "B", "C");
        Stream<String> stream2 = Stream.of("가", "나", "다");

        Stream<String> stream3 = Stream.concat(stream1, stream2);
        stream3.forEach(text -> System.out.println(text));
    }

}

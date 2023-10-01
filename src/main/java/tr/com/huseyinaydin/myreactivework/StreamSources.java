package tr.com.huseyinaydin.myreactivework;

import java.util.stream.Stream;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Spring Boot.
 * @since 1994
 */

public class StreamSources {

    public static Stream<String> stringNumbersStream() {
        return Stream.of("bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz", "on");
    }

    public static Stream<Integer> intNumbersStream() {
        return Stream.iterate(0, i -> i + 2)
                .limit(10);
    }

    public static Stream<User> userStream() {
        return Stream.of(
                new User(1, "Hasan", "Öner"),
                new User(2, "Ramazan", "Sönmez"),
                new User(2, "Ayşe", "Elbistan"),
                new User(4, "Türkan", "Gözübüyük"),
                new User(5, "Nurgül", "Yeşilçay"),
                new User(6, "Veli", "Karaçay")
        );
    }
}
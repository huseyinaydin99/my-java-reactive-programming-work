package tr.com.huseyinaydin.myreactivework;

import reactor.core.Disposable;

import java.io.IOException;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Spring Boot.
 * @since 1994
 */

public class Main {
    public static void main(String[] args) throws IOException {
        //ReactiveSources.intNumbersFlux().subscribe(value -> System.out.println(value));
        ///ReactiveSources.intNumbersFlux().subscribe(System.out::println);
        /*ReactiveSources.intNumbersFlux().subscribe(
                value -> System.out.println(value),
                err -> System.out.println(err),
                () -> System.out.println("Tamamlandi")
        );*/

        /*ReactiveSources.unresponsiveMono().subscribe(System.out::println);
        ReactiveSources.unresponsiveFlux().subscribe(System.out::println);*/

        /*ReactiveSources.intNumbersFluxWithException().subscribe(
                value -> System.out.println(value),
                err -> System.out.println("Hata var. İlgili hata: " + err),
                () -> System.out.println("Tamamlandi")
        );*/
        //ReactiveSources.intNumberMono().subscribe(System.out::println);
        //ReactiveSources.stringNumbersFlux().subscribe(System.out::println);
        //ReactiveSources.intNumbersFlux().filter(number -> number < 5).toStream().forEach(System.out::println);

        /*var user = ReactiveSources.userMono().block();
        System.out.println(user);*/

        //StreamSources.userStream().filter(user -> StreamSources.intNumbersStream().anyMatch(number -> user.getId() == number)).forEach(System.out::println);
        Disposable disposable = ReactiveSources.intNumbersFlux().subscribe(
                val -> System.out.println(val),
                err -> System.out.println(err),
                () -> System.out.println("Tamamlandı."),
                subscription -> {
                    System.out.println(subscription.toString());
                }
        );
        System.out.println("Kapanması için bir tuşa bas.");
        System.in.read();
    }
}

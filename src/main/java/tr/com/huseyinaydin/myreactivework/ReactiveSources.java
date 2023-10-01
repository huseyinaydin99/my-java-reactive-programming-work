package tr.com.huseyinaydin.myreactivework;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

//بسم الله الرحمن الرحيم

/**
 * @author Huseyin_Aydin
 * @category Java, Spring Boot.
 * @since 1994
 */

public class ReactiveSources {

    public static Flux<String> stringNumbersFlux() {
        return Flux.just("bir", "iki", "üç", "dört", "beş", "altı", "yedi", "sekiz", "dokuz", "on")
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFlux() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> intNumbersFluxWithException() {
        return Flux
                .range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .map(e -> {
                    if (e == 5) throw new RuntimeException("Beşe ulaştı o yüzden hata verdim.");
                    return e;
                });
    }

    public static Mono<Integer> intNumberMono() {
        return Mono.just(42)
                .delayElement(Duration.ofSeconds(1));
    }

    public static Flux<User> userFlux() {
        return Flux.just(
                new User(1, "Hasan", "Öner"),
                new User(2, "Ramazan", "Sönmez"),
                new User(2, "Ayşe", "Elbistan"),
                new User(4, "Türkan", "Gözübüyük"),
                new User(5, "Nurgül", "Yeşilçay"),
                new User(6, "Veli", "Karaçay")
        ).delayElements(Duration.ofSeconds(1));
    }

    public static Mono<User> userMono() {
        return Mono.just(
                new User(1, "Erhan", "Bülbül")
        ).delayElement(Duration.ofSeconds(1));
    }

    public static Flux<String> unresponsiveFlux() {
        return Flux.never();
    }

    public static Mono<String> unresponsiveMono() {
        return Mono.never();
    }

    public static Flux<Integer> intNumbersFluxWithRepeat() {
        return Flux
                .just(1, 2, 1, 1, 3, 2, 4, 5, 1)
                .delayElements(Duration.ofSeconds(1));
    }
}
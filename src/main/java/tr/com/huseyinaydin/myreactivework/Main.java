package tr.com.huseyinaydin.myreactivework;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

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
        /*Disposable disposable = ReactiveSources.intNumbersFlux().subscribe(
                val -> {
                    System.out.println(val);
                },
                err -> System.out.println(err),
                () -> System.out.println("Tamamlandı."),
                subscription -> {
                    System.out.println(subscription.toString());
                }
        );*/
        //String foo = ReactiveSources.unresponsiveMono().block(Duration.ofSeconds(5));
        /*List<Integer> numbers = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();
        System.out.println(numbers);*/
        /*ReactiveSources //burada tüm işlemler loglanır. log metodu öncesinde çalıştırılmış.
                .intNumbersFlux()
                .log()
                .filter(e -> e > 5)
                .subscribe(System.out::println);*/
        /*ReactiveSources
                .intNumbersFlux()
                .filter(e -> e > 5) //burada tüm işlemler loglanmaz! filter metodu log metodu öncesinde çalıştırılmış.
                .log() //filtreleme işlemi yapılırken log devrede değil!
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFlux()
                .filter(n -> n > 20)
                .defaultIfEmpty(-1) //boş dönerse -1 yazar.
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFlux()
                .flatMap(n -> ReactiveSources.userFlux().filter(user -> user.getId() == n).take(1))
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .log()
                .subscribe();*/
        /*ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .log()
                .subscribe();*/
        /*ReactiveSources.intNumbersFluxWithException() //hata olduğunda hatayı yakalar ama exception fırmatıldığında kodlar devam etmez kesilir bu kullanım senaryosunda.
                .doOnError(e -> System.out.println("Excepiton: " + e.getMessage()))
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFluxWithException() //bu kullanım senaryosunda ise exception fırlatıldığında program kesilmez devam eder. aynı try cache yapısımsı bir şeydir. excepiton olduğıunda hatayı ignore eder.
                .onErrorContinue((e, item) -> System.out.println("Excepiton: " + e.getMessage()))
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFluxWithException() //bu kullanım senaryosunda ise exception fırlatıldığında program kesilir. Exception olduğunda -1 ve -2 değerleri yazılır program durur.
                .onErrorResume(err -> Flux.just(-1, -2))
                .subscribe(System.out::println);*/
        /*ReactiveSources.intNumbersFluxWithException()
                .doFinally(signalType -> { //try cache yapısındaki aynı finally
                    if (signalType == SignalType.ON_COMPLETE)
                        System.out.println("Tamamlandı!");
                    else if (signalType == SignalType.ON_ERROR)
                        System.out.println("Hata!");
                })
                .subscribe(System.out::println);*/
        //ReactiveSources.intNumbersFlux().collectList().subscribe(System.out::println);
        //ReactiveSources.intNumbersFlux().count().subscribe(System.out::println); //toplam count'unu(eleman sayısı) alır.
        ReactiveSources.intNumbersFlux()
                .buffer(2) //listedeki elemanları 2 2 alacan dedik. bir liste oluşur listede 2 eleman olur. sıra sıra 2'şer alır.
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);
        //ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
        System.out.println("Kapanması için bir tuşa bas.");
        System.in.read();
    }
}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Abonelik gerçekleşti");
        request(1);
    }

    @Override
    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(1);
    }
}
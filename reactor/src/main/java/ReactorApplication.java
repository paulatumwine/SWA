import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 2021-01-07T22:52:38.374
 * 2021-01-07T22:52:43.948 : Frank
 *
 * 2021-01-07T22:53:48.709
 * 2021-01-07T22:53:54.749 : Walter
 * 2021-01-07T22:53:59.751 : Skyler
 * 2021-01-07T22:54:04.753 : Saul
 * 2021-01-07T22:54:09.754 : Jesse
 */
public class ReactorApplication {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(LocalDateTime.now());

//        Mono<String> mono = Mono.just("Frank").delayElement(Duration.ofSeconds(5));
//        mono.subscribe(s -> printName(s));
//        Thread.sleep(10000L);

        Flux<String> flux = Flux.just("Walter", "Skyler", "Saul", "Jesse").delayElements(Duration.ofSeconds(5));
        flux.subscribe(s -> printName(s));
        Thread.sleep(30000);
    }

    public static void printName(String name) {
        System.out.print(LocalDateTime.now()+" : ");
        System.out.println(name);
    }
}

package tech.hm.sec02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec08FluxFromMono {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("a");
        Flux<String> flux = Flux.from(mono);
    }
}

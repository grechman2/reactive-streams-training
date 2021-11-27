package tech.hm.sec01;

import reactor.core.publisher.Mono;
import tech.hm.courceutils.Util;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {
        // use just only when you have data already
        // Mono.just(getName())   --- getName will be invoked right away, but we need to postpone it.


        // Lazy initialization
        Mono<String> mono = Mono.fromSupplier(() -> getName());
        mono.subscribe(Util.onNext());

        Mono<String> mono2 = Mono.fromCallable(() -> getName());
        mono2.subscribe(Util.onNext());
    }


    // time consuming operation
    private static String getName(){
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }

}

package tech.hm.sec02;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

public class Lec01FluxIntro {

    public static void main(String[] args) {
        Flux<Integer> just = Flux.just(1, 2, 3, 4);

        just.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}

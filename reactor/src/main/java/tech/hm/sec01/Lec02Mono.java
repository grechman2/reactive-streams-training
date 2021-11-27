package tech.hm.sec01;

import reactor.core.Disposable;
import reactor.core.publisher.Mono;
import tech.hm.courceutils.Util;

public class Lec02Mono {

    public static void main(String[] args) {

        // Errors
        Mono<Integer> mono = Mono.just(1).map(i -> i/0);

        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete());
    }

}

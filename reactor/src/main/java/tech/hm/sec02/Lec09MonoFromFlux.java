package tech.hm.sec02;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

public class Lec09MonoFromFlux {

    public static void main(String[] args) {
        Flux.range(1,10)
                .filter( i -> i == 5)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }

}

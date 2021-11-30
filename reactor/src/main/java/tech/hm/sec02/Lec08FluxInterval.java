package tech.hm.sec02;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

import java.time.Duration;

public class Lec08FluxInterval {


    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(Util.onNext());

        Util.sleepSeconds(10);

    }
}

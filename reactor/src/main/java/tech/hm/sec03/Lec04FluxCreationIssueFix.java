package tech.hm.sec03;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

public class Lec04FluxCreationIssueFix {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                System.out.println(" emmiting : " + country);
                fluxSink.next(country);
            } while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled());
            fluxSink.complete();
        })
                .take(3)
                .subscribeWith(Util.getDefaultSubscriber());

    }
}

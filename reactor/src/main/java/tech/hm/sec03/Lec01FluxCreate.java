package tech.hm.sec03;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

public class Lec01FluxCreate {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {
            String country;
            do{
               country = Util.faker().country().name();
               fluxSink.next(country);
            }while (!country.equalsIgnoreCase("canada"));
            fluxSink.complete();

        }).subscribeWith(Util.getDefaultSubscriber());

    }
}

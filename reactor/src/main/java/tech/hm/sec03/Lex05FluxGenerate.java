package tech.hm.sec03;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

public class Lex05FluxGenerate {

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {
            String name = Util.faker().country().name();
            synchronousSink.next(name);
            if(name.equalsIgnoreCase("canada")){
                synchronousSink.complete();
            }
        })
        .subscribeWith(Util.getDefaultSubscriber());

    }
}

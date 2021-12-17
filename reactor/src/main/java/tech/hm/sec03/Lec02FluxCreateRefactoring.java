package tech.hm.sec03;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;
import tech.hm.sec03.common.NameProducer;

public class Lec02FluxCreateRefactoring {

    public static void main(String[] args) {
        NameProducer producer = new NameProducer();
        Flux.create(producer).subscribeWith(Util.getDefaultSubscriber());

        producer.produce();
    }
}

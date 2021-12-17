package tech.hm.sec03;

import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;
import tech.hm.sec03.common.NameProducer;

public class Lec04FluxMultipleThreads {

    public static void main(String[] args) {
        NameProducer producer = new NameProducer();
        Flux.create(producer).subscribeWith(Util.getDefaultSubscriber());

        Runnable runnable = producer::produce;
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(3);
    }
}

package tech.hm.sec03.common;

import reactor.core.publisher.FluxSink;
import tech.hm.courceutils.Util;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    FluxSink<String> sink;

    @Override
    public void accept(FluxSink<String> fluxSink) {
        this.sink = fluxSink;
    }

    public void produce(){
        String name = Util.faker().name().fullName();
        String threadName = Thread.currentThread().getName();
        this.sink.next(threadName + " : " + name);
    }
}

package tech.hm.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.hm.courceutils.Util;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {
        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic()) // without this, pipe will be executed in the main thread.
                .subscribe(Util.onNext());

        String block = getName()
                .subscribeOn(Schedulers.boundedElastic()) // without this, pipe will be executed in the main thread.
                .block();// will give you result directly, it is blocking subscriber, useful for testing purpose.
        System.out.println(block);

        getName();

        Util.sleepSeconds(5);
    }

    private static Mono<String> getName(){
        System.out.println("Entered getName method");
        return Mono.fromSupplier(()->{
            System.out.println("Generating name");
            Util.sleepSeconds(3);
            return Util.faker().name().fullName();
        }).map(String::toUpperCase);
    }

}

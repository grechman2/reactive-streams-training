package tech.hm.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.hm.courceutils.Util;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(getName()).subscribe(Util.onNext());

        Util.sleepSeconds(5);
    }


    private static CompletableFuture<String> getName(){
        return CompletableFuture.supplyAsync(()-> Util.faker().name().fullName());
    }


}

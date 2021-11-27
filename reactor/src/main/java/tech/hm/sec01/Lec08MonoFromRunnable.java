package tech.hm.sec01;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import tech.hm.courceutils.Util;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        // it is used to be notified on operation completion
        Mono.fromRunnable(timeConsumingProcess())
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("process is done. Sending email.");
                        });

        Util.sleepSeconds(6);
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            System.out.println("Thread name :" + Thread.currentThread().getName());
            Util.sleepSeconds(3);
            System.out.println("Operation completed");
        };
    }


}

package tech.hm.sec02;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06CustomSubscriver {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 10)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Receive sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("On next: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("On error: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("On complete:");
                    }
                });
    }
}

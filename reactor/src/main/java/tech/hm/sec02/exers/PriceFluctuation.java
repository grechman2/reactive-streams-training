package tech.hm.sec02.exers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import tech.hm.courceutils.Util;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PriceFluctuation {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1);

        getPrice().subscribeWith(new Subscriber<Integer>() {
            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                this.subscription = subscription;
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer value) {
                System.out.println(LocalDateTime.now() + " : Price " + value);
                if(value > 110 || value < 90){
                    System.out.println("Limit is reached");
                    subscription.cancel();
                    latch.countDown();
                }
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error");
                latch.countDown();
            }

            @Override
            public void onComplete() {
                System.out.println("complete");
                latch.countDown();
            }
        });

        latch.await();
    }

    public static Flux<Integer> getPrice(){
        AtomicInteger number = new AtomicInteger(100);
        return Flux.interval(Duration.ofSeconds(1))
                .map(i -> number.getAndAccumulate(Util.faker().random().nextInt(-5, +5), Integer::sum));
    }

}

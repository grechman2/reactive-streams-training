package tech.hm.courceutils;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    private static final Faker FAKER = Faker.instance();

    public static Consumer<Object> onNext(){
        return o -> System.out.println(Thread.currentThread().getName() + " - Received : " + o);
    }

    public static Consumer<Throwable> onError(){
        return e -> System.out.println("ERROR: " + e.getMessage());
    }

    public static Runnable onComplete(){
        return () -> System.out.println("Completed");
    }

    public static Faker faker() {
        return FAKER;
    }

    public static Subscriber<Object> getDefaultSubscriber(){
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> getDefaultSubscriber(String name){
        return new DefaultSubscriber(name);
    }

    public static void sleepSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {

        }
    }
}

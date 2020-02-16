import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_09 {
    public static void main(String[] args) {
        Observable<Integer> lengths =
            Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                    .subscribeOn(Schedulers.computation())
                    .map(Ch6_09::intenseCalculation)
                    .map(String::length)
                    .publish()
                    .autoConnect(2);
        lengths.subscribe(i -> System.out.println("Received " + i +
                " on thread " + Thread.currentThread().getName()));
        lengths.subscribe(i -> System.out.println("Received " + i +
                " on thread " + Thread.currentThread().getName()));
        sleep(10000);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
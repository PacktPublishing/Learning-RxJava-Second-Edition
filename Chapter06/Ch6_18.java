import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class Ch6_18 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                  .flatMap(i -> Observable.just(i)
                              .subscribeOn(Schedulers.computation())
                              .map(i2 -> intenseCalculation(i2)))
                .subscribe(i -> System.out.println("Received " + i +
                             " " + LocalTime.now() + " on thread " +
                                 Thread.currentThread().getName()));
        sleep(20000);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
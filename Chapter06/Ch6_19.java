import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class Ch6_19 {
    public static void main(String[] args) {
        int coreCount = Runtime.getRuntime().availableProcessors();
        AtomicInteger assigner = new AtomicInteger(0);
        Observable.range(1, 10)
                  .groupBy(i -> assigner.incrementAndGet() % coreCount)
                  .flatMap(grp -> grp.observeOn(Schedulers.io())
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
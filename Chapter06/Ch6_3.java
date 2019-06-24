import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class Ch6_3 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .subscribeOn(Schedulers.computation())
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        Observable.range(1, 3)
                .subscribeOn(Schedulers.computation())
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
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
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;


public class Ch8_4 {
    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(System.out::println, Throwable::printStackTrace);
        sleep(Long.MAX_VALUE);
    }
    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

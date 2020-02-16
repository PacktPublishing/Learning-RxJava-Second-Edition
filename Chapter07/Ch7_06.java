import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Ch7_06 {
    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                  .map(i -> (i + 1) * 300)
                  .buffer(1, TimeUnit.SECONDS, 2)
                  .subscribe(System.out::println);
        sleep(5000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
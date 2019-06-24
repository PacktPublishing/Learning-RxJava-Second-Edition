import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class Ch10_1 {
    @Test
    public void demoCode() {
        Observable.interval(1, TimeUnit.SECONDS)
                  .take(5)
                  .subscribe(System.out::println);
        sleep(6000);
    }
    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

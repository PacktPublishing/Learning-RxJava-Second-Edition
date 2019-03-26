import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch2_17 {
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(s -> System.out.println(s + " Mississippi"));
        sleep(3000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
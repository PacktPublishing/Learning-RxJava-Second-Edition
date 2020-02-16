import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Ch3_70 {
    public static void main(String[] args) {
        Observable.interval(2, TimeUnit.SECONDS)
                .doOnNext(i -> System.out.println("Emitted: " + i))
                .take(3)
                .timeInterval(TimeUnit.SECONDS)
                .subscribe(i -> System.out.println("Received: " + i.time() + " " + i.unit() + " " + i.value()));
        sleep(7000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
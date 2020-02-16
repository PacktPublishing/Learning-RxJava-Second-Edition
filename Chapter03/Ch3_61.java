import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.TimeUnit;

public class Ch3_61 {
    public static void main(String[] args) {
        Disposable disp = Observable.interval(1, TimeUnit.SECONDS)
                .doOnSubscribe(d -> System.out.println("Subscribing!"))
                .doOnDispose(() -> System.out.println("Disposing!"))
                .doFinally(() -> System.out.println("doFinally!"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i));

        sleep(3000);
        disp.dispose();
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

import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Ch4_04 {
    public static void main(String[] args) {
        //emit every second
        Observable<String> src1 = Observable.interval(1,
                TimeUnit.SECONDS)
                .map(l -> l + 1) // emit elapsed seconds
                .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> src2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
        //merge and subscribe
        Observable.merge(src1, src2)
                .subscribe(System.out::println);
        //keep alive for 3 seconds
        sleep(3000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
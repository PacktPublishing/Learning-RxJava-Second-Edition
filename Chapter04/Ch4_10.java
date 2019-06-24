import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Ch4_10 {
    public static void main(String[] args) {
        //emit every second, but only take 2 emissions
        Observable<String> src1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(2)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
        //emit every 300 milliseconds
        Observable<String> src2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed millis
                        .map(l -> "Source2: " + l + " milliseconds");
        Observable.concat(src1, src2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        //keep application alive for 5 seconds
        sleep(5000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
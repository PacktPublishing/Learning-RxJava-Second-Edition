import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class Ch5_10 {
    public static void main(String[] args) {
        Observable<Long> ints =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .refCount();
        //Observer 1
        ints.take(5)
                .subscribe(l -> System.out.println("Observer 1: " + l));
        sleep(3000);
        //Observer 2
        ints.take(2)
                .subscribe(l -> System.out.println("Observer 2: " + l));
        sleep(3000);
        //there should be no more Observers at this point
        //Observer 3
        ints.subscribe(l -> System.out.println("Observer 3: " + l));
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
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_04 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> ints =
                Observable.range(1, 3).publish();
        Observable<Integer> rInts = ints.map(i ->
                randomInt());
        rInts.subscribe(i -> System.out.println("Observer 1: " + i));
        rInts.subscribe(i -> System.out.println("Observer 2: " + i));
        ints.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
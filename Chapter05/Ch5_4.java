import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_4 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> ints =
                Observable.range(1, 3).publish();
        Observable<Integer> rndmInts = ints.map(i ->
                randomInt());
        rndmInts.subscribe(i -> System.out.println("Observer 1: " + i));
        rndmInts.subscribe(i -> System.out.println("Observer 2: " + i));
        ints.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
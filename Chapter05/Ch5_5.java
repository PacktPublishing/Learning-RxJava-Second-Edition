import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_5 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> rndmInts =
                Observable.range(1, 3)
                        .map(i -> randomInt()).publish();
        rndmInts.subscribe(i -> System.out.println("Observer 1: " + i));
        rndmInts.subscribe(i -> System.out.println("Observer 2: " + i));
        rndmInts.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
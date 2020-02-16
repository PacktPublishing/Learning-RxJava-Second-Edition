import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_05 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> rInts =
                Observable.range(1, 3).map(i -> randomInt()).publish();
        rInts.subscribe(i -> System.out.println("Observer 1: " + i));
        rInts.subscribe(i -> System.out.println("Observer 2: " + i));
        rInts.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
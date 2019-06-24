import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_6 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> rndmInts =
                Observable.range(1, 3)
                        .map(i -> randomInt()).publish();

        //Observer 1 - print each random integer
        rndmInts.subscribe(i -> System.out.println("Observer 1: " + i));

        //Observer 2 - sum the random integers, then print
        rndmInts.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        rndmInts.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
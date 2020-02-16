import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observables.ConnectableObservable;
import java.util.concurrent.ThreadLocalRandom;

public class Ch5_06 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> rInts =
                Observable.range(1, 3)
                        .map(i -> randomInt()).publish();

        //Observer 1 - print each random integer
        rInts.subscribe(i -> System.out.println("Observer 1: " + i));

        //Observer 2 - sum the random integers, then print
        rInts.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        rInts.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
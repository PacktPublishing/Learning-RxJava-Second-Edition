import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_03 {
    public static void main(String[] args) {
        Observable<Integer> ints = Observable.range(1, 3)
                .map(i -> randomInt());
        ints.subscribe(i -> System.out.println("Observer 1: " + i));
        ints.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
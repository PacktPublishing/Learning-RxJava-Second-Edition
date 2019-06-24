import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class Ch5_8 {
    public static void main(String[] args) {
        Observable<Integer> rndmInts = Observable.range(1, 3)
                .map(i -> randomInt()).publish().autoConnect(2);
        //Observer 1 - prints each random integer
        rndmInts.subscribe(i -> System.out.println("Observer 1: " + i));
        //Observer 2 - sums the random integers, then prints
        rndmInts.reduce(0, (total, next) -> total + next)
                        .subscribe(i -> System.out.println("Observer 2: " + i));
        //Observer 3 - receives nothing
        rndmInts.subscribe(i -> System.out.println("Observer 3:" + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
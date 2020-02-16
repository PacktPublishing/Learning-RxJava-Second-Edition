import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.TimeUnit;

public class Ch4_07a {
    public static void main(String[] args) {
        Observable.just(2, 0, 3, 10, 7)
                .flatMap(i -> {
                    if (i == 0){
                        return Observable.empty();
                    }
                    else {
                        return Observable.interval(i, TimeUnit.SECONDS)
                                .map(l -> i + "s interval: " +
                                        ((l + 1) * i) + " seconds elapsed");
                    }
                })
                .subscribe(System.out::println);
        sleep(12000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

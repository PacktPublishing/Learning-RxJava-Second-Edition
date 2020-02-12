import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Ch8_12 {
    public static void main(String[] args) {
        Flowable<Integer> integers =
                Flowable.range(1, 1000)
                        .subscribeOn(Schedulers.computation());
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .flatMap(s -> integers.map(i -> i + "-" + s).toObservable())
                  .subscribe(System.out::println);
        sleep(5000);
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
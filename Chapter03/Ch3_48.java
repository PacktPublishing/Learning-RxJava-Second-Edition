import io.reactivex.rxjava3.core.Observable;

public class Ch3_48 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3)
                .map(i -> 10 / i)
                .retry()
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                     e -> System.out.println("RECEIVED ERROR: " + e));
    }
}
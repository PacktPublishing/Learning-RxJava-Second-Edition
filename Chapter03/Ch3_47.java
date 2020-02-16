import io.reactivex.rxjava3.core.Observable;

public class Ch3_47 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3)
                .map(i -> 10 / i)
                .onErrorResumeNext((Throwable e) ->
                        Observable.just(-1).repeat(3))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                     e -> System.out.println("RECEIVED ERROR: " + e));
    }
}
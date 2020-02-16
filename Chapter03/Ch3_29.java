import io.reactivex.rxjava3.core.Observable;

public class Ch3_29 {
    public static void main(String[] args) {
        Observable<String> obs1 = Observable.just("One", "Two", "Three");
        Observable<String> obs2 = Observable.just("One", "Two", "Three");
        Observable<String> obs3 = Observable.just("Two", "One", "Three");
        Observable<String> obs4 = Observable.just("One", "Two");

        Observable.sequenceEqual(obs1, obs2)
                .subscribe(s -> System.out.println("Received: " + s));

        Observable.sequenceEqual(obs1, obs3)
                .subscribe(s -> System.out.println("Received: " + s));

        Observable.sequenceEqual(obs1, obs4)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
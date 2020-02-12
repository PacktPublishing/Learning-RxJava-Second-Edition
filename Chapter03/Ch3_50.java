import io.reactivex.rxjava3.core.Observable;

public class Ch3_50 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .doOnNext(s -> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}
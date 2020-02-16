import io.reactivex.rxjava3.core.Observable;

public class Ch3_10 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .distinct(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
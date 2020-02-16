import io.reactivex.rxjava3.core.Observable;

public class Ch3_22 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
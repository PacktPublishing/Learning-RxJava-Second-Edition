import io.reactivex.rxjava3.core.Observable;

public class Ch3_23 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .scan(0, (total, next) -> total + 1)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
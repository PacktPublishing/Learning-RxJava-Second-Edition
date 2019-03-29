import io.reactivex.Observable;

public class Ch3_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .take(2)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
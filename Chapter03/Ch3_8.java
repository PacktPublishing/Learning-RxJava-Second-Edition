import io.reactivex.Observable;

public class Ch3_8 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .distinct(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
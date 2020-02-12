import io.reactivex.rxjava3.core.Observable;

public class Ch3_31 {
    public static void main(String[] args) {
        Observable.range(1, 1000)
                .toList(1000)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
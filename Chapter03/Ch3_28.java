import io.reactivex.rxjava3.core.Observable;

public class Ch3_28 {
    public static void main(String[] args) {
        Observable.range(1, 10000)
                .contains(9563)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
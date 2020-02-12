import io.reactivex.rxjava3.core.Observable;

public class Ch2_27 {
    public static void main(String[] args) {
        Observable.fromCallable(() -> 1 / 0)
                .subscribe(i -> System.out.println("Received: " + i),
                        e -> System.out.println("Error captured: " + e)
                );
    }
}
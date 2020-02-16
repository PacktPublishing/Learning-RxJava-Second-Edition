import io.reactivex.rxjava3.core.Observable;

public class Ch3_60 {
    public static void main(String[] args) {
        Observable.just("One", "Two", "Three")
                .doFinally(() -> System.out.println("doFinally!"))
                .doAfterTerminate(() -> System.out.println("doAfterTerminate!"))
                .subscribe(i -> System.out.println("Received: " + i));
    }
}

import io.reactivex.rxjava3.core.Observable;

public class Ch2_30b {
    public static void main(String[] args) {
        // has emission
        Observable<Integer> source = Observable.just(100);
        source.subscribe(s -> System.out.println("Process 1: " + s),
                e -> System.out.println("Error captured: " + e),
                () -> System.out.println("Process 1 done!"));
        //no emission
        Observable<Integer> empty = Observable.empty();
        empty.subscribe(s -> System.out.println("Process 2: " + s),
                e -> System.out.println("Error captured: " + e),
                () -> System.out.println("Process 2 done!"));
    }
}

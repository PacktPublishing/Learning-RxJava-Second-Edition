import io.reactivex.rxjava3.core.Maybe;

public class Ch2_30a {
    public static void main(String[] args) {
        // has emission
        Maybe<Integer> source = Maybe.just(100);
        source.subscribe(s -> System.out.println("Process 1: " + s),
                e -> System.out.println("Error captured: " + e),
                () -> System.out.println("Process 1 done!"));
        //no emission
        Maybe<Integer> empty = Maybe.empty();
        empty.subscribe(s -> System.out.println("Process 2: " + s),
                e -> System.out.println("Error captured: " + e),
                () -> System.out.println("Process 2 done!"));
    }
}
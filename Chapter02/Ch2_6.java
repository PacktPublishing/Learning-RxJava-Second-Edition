import io.reactivex.Observable;

import java.util.List;

public class Ch2_6 {
    public static void main(String[] args) {
        List<String> items =
                List.of("Alpha", "Beta", "Gamma");
        Observable<String> source = Observable.fromIterable(items);
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
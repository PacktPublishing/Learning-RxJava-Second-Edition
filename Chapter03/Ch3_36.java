import io.reactivex.rxjava3.core.Observable;
import java.util.concurrent.ConcurrentHashMap;

public class Ch3_36 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .toMap(s -> s.charAt(0), String::length,
                        ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
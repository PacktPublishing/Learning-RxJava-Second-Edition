import io.reactivex.rxjava3.core.Observable;

public class Ch4_08 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .flatMap(s -> Observable.fromArray(s.split("")),
                        (s, r) -> s + "-" + r)
                .subscribe(System.out::println);
    }
}
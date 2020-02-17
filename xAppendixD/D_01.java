import io.reactivex.rxjava3.core.Observable;

public class D_01 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.materialize()
                .subscribe(System.out::println);
    }
}

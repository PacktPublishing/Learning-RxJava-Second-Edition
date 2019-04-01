import io.reactivex.Observable;

public class Ch4_11 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma");
        source.concatMap(s -> Observable.fromArray(s.split("")))
              .subscribe(System.out::println);
    }
}
import io.reactivex.rxjava3.core.Observable;

public class Ch2_12 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma");
        //first observer
        source.subscribe(s -> System.out.println("Observer 1: " + s));
        //second observer
        source.map(String::length)
                .filter(i -> i >= 5)
                .subscribe(s -> System.out.println("Observer 2: " + s));
    }
}
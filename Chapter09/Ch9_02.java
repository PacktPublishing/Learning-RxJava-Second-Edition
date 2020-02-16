import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class Ch9_02 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .compose(joinToString("/"))
                  .subscribe(System.out::println);
    }

    private static ObservableTransformer<String, String> joinToString(String separator) {
        return upstream -> upstream
                .collect(StringBuilder::new, (b, s) -> {
                    if (b.length() == 0){
                        b.append(s);
                    }
                    else {
                        b.append(separator).append(s);
                    }
                })
                .map(StringBuilder::toString)
                .toObservable();
    }
}
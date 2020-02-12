import io.reactivex.rxjava3.core.Observable;

public class Ch4_13 {
    public static void main(String[] args) {
        Observable<String> src1 =
                Observable.just("Alpha", "Beta", "Gamma");
        Observable<Integer> src2 = Observable.range(1, 6);
        Observable.zip(src1, src2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);
    }
}
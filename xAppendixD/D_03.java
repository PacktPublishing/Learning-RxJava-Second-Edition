import io.reactivex.rxjava3.core.Observable;

public class D_03 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .materialize()
                .doOnNext(System.out::println)
                //.dematerialize()                 //RxJava 2.*
                .dematerialize(v -> v)
                .subscribe(System.out::println);
    }
}

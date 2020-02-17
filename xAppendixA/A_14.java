import io.reactivex.rxjava3.core.Observable;

public class A_14 {
    public static void main(String[] args) {
        Observable.just("Alpha","Beta","Gamma")
                .map(String::length) //accepts Function<T,R>
                .subscribe(System.out::println); //accepts Consumer<T>
    }
}

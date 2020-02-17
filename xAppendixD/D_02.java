import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Observable;

public class D_02 {
    public static void main(String[] args) {
        Observable<Notification<String>> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                        .materialize()
                        .publish()
                        .autoConnect(3);

        source.filter(Notification::isOnNext)
                .subscribe(n -> System.out.println("onNext=" +
                        n.getValue()));

        source.filter(Notification::isOnComplete)
                .subscribe(n -> System.out.println("onComplete"));

        source.filter(Notification::isOnError)
                .subscribe(n -> System.out.println("onError"));
    }
}

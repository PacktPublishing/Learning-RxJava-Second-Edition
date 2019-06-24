import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Ch5_2 {
    public static void main(String[] args) {
        ConnectableObservable<Integer> ints =
                Observable.range(1, 3).publish();
        ints.subscribe(i -> System.out.println("Observer One:" + i));
        ints.subscribe(i -> System.out.println("Observer Two:" + i));
        ints.connect();
    }
}
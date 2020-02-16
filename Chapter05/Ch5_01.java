import io.reactivex.rxjava3.core.Observable;

public class Ch5_01 {
    public static void main(String[] args) {
        Observable<Integer> ints = Observable.range(1, 3);
        ints.subscribe(i -> System.out.println("Observer One: " + i));
        ints.subscribe(i -> System.out.println("Observer Two: " + i));
    }
}
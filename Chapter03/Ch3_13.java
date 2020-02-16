import io.reactivex.rxjava3.core.Observable;

public class Ch3_13 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma")
                .elementAt(3)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
import io.reactivex.Observable;

public class Ch4_1 {
    public static void main(String[] args) {
        Observable<String> src1 = Observable.just("Alpha", "Beta");
        Observable<String> src2 = Observable.just("Zeta", "Eta", "Theta");
        Observable.merge(src1, src2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
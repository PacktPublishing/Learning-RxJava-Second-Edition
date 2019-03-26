import io.reactivex.Observable;

public class Ch2_16 {
    public static void main(String[] args) {
        Observable.range(5, 3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}
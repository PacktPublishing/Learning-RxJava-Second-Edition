import io.reactivex.Observable;

public class Ch3_25 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7)
                .reduce((total, i) -> total + i)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
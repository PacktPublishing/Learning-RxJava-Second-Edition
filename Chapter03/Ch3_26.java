import io.reactivex.rxjava3.core.Observable;

public class Ch3_26 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7)
                .reduce("", (total, i) -> total + (total.equals("") ? "" : ",") + i)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
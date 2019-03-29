import io.reactivex.Observable;

public class Ch3_33 {
    public static void main(String[] args) {
        Observable.just("Beta", "Gamma", "Alpha")
                .toSortedList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
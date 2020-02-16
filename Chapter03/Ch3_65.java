import io.reactivex.rxjava3.core.Observable;

public class Ch3_65 {
    public static void main(String[] args) {
        Observable.just("One")
                .single("Four")
                .subscribe(i -> System.out.println("Received: " + i));
    }
}

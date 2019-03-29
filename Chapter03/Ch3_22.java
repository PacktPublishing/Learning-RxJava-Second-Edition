import io.reactivex.Observable;

public class Ch3_22 {
    public static void main(String[] args) {
        Observable.just(5, 3, 7)
                .scan((accumulator, i) -> accumulator + i)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}
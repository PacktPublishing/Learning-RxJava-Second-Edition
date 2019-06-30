import io.reactivex.Observable;
public class Ch3_55 {
    public static void main(String[] args) {
        Observable.just("One", "Two", "Three")
                  .filter(s -> s.contains("z"))
                  .isEmpty()
                  .subscribe(s -> System.out.println("Received: " + s));

        Observable.just("One", "Twoz", "Three")
                .filter(s -> s.contains("z"))
                .isEmpty()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}

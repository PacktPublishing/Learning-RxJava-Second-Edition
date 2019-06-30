import io.reactivex.Observable;
public class Ch3_66 {
    public static void main(String[] args) {
        Observable.just("One", "Two", "Three")
                .filter(s -> s.contains("z"))
                .single("Four")
                .subscribe(i -> System.out.println("Received: " + i));
    }
}
import io.reactivex.Observable;
import java.util.HashSet;

public class Ch7_1a {
    public static void main(String[] args) {
        Observable.range(1,50)
                  .buffer(8, HashSet::new)
                  .subscribe(System.out::println);
    }
}
import io.reactivex.rxjava3.core.Observable;

public class Ch7_02 {
    public static void main(String[] args) {
        Observable.range(1, 10)
                  .buffer(2, 3)
                  .subscribe(System.out::println);
    }
}
import io.reactivex.rxjava3.core.Observable;

public class Ch7_09 {
    public static void main(String[] args) {
        Observable.range(1, 50)
                  .window(2, 3)
                  .flatMapSingle(obs -> obs.reduce("",
                          (total, next) -> total + (total.equals("") ? "" : "|") + next))
                  .subscribe(System.out::println);
    }
}
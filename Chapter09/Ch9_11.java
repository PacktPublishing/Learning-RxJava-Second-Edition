import com.github.davidmoten.rx2.flowable.Transformers;
import io.reactivex.Flowable;

public class Ch9_11 {
    public static void main(String[] args) {
        Flowable.just("Alpha","Beta","Zeta","Gamma","Delta","Theta","Epsilon")
                .compose(Transformers.toListWhile((list, next) ->
                        list.size() == 0 || list.get(0).length() == next.length()
                ))
                .subscribe(System.out::println);
    }
}

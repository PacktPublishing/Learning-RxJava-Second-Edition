import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class Ch9_1b {
    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .compose(toImmutableList())
                  .subscribe(System.out::println);

        Observable.range(1, 10)
                  .compose(toImmutableList())
                  .subscribe(System.out::println);
    }

    private static <T> ObservableTransformer<T, ImmutableList<T>> toImmutableList() {
        return upstream ->
                upstream.collect(ImmutableList::<T> builder, ImmutableList.Builder::add)
                        .map(ImmutableList.Builder::build)
                        .toObservable(); // must turn Single into Observable
    }
}
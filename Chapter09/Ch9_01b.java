import com.google.common.collect.ImmutableList;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableTransformer;

public class Ch9_01b {
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
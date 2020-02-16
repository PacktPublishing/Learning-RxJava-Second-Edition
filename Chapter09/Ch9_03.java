import com.google.common.collect.ImmutableList;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;

public class Ch9_03 {
    public static void main(String[] args) {
        Flowable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .compose(toImmutableList())
                .subscribe(System.out::println);
        Flowable.range(1, 10)
                .compose(toImmutableList())
                .subscribe(System.out::println);
    }

    private static <T> FlowableTransformer<T, ImmutableList<T>> toImmutableList() {
        return upstream ->
                upstream.collect(ImmutableList::<T>builder,
                        ImmutableList.Builder::add)
                        .map(ImmutableList.Builder::build)
                        .toFlowable(); // must turn Single into Flowable
    }
}
import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class Ch9_4c {
    public static void main(String[] args) {
        Observable<IndexedValue<String>> indexedStrings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                          .compose(withIndex());

        indexedStrings.subscribe(v -> System.out.println("Subscriber 1: " + v));

        indexedStrings.subscribe(v -> System.out.println("Subscriber 2: " + v));
    }

    private static <T> ObservableTransformer<T,IndexedValue<T>> withIndex() {
        return upstream ->
                Observable.zip(upstream,
                               Observable.range(0, Integer.MAX_VALUE),
                               (v, i) -> new IndexedValue<T>(i, v)
                );
    }

    private static final class IndexedValue<T> {
        final int index;
        final T value;

        IndexedValue(int index, T value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public String toString() {
            return index + " - " + value;
        }
    }
}
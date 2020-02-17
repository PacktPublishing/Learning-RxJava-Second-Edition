import io.reactivex.rxjava3.core.Emitter;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Supplier;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicReference;

public class C_02 {
    public static void main(String[] args) {
        Supplier<AtomicReference<LocalDate>> initialState =
                () -> new AtomicReference<>(LocalDate.of(2020,1,1));

        BiConsumer<AtomicReference<LocalDate>, Emitter<LocalDate>> generator =
                (AtomicReference<LocalDate> next, Emitter<LocalDate> emitter) ->
                        emitter.onNext(next.getAndUpdate(dt -> dt.plusDays(1)));

        Flowable.generate(initialState, generator)
                .take(60)
                .subscribe(System.out::println);
    }
}

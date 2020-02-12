import io.reactivex.rxjava3.core.Observable;

public class Ch2_36 {
    public static void main(String[] args) {
        Observable<Integer> source =
            Observable.create(observableEmitter -> {
                try {
                    for (int i = 0; i < 1000; i++) {
                        while (!observableEmitter.isDisposed()) {
                            observableEmitter.onNext(i);
                        }
                        if (observableEmitter.isDisposed()) {
                            return;
                        }
                    }
                    observableEmitter.onComplete();
                } catch (Throwable e) {
                    observableEmitter.onError(e);
                }
            });
    }
}
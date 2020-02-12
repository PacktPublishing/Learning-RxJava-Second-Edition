import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Ch6_13 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                  .subscribeOn(Schedulers.computation())
                  .filter(s -> s.length() == 5)
                  .subscribeOn(Schedulers.io())
                  .subscribe(i -> System.out.println("Received " + i +
                     " on thread " + Thread.currentThread().getName()));
        sleep(5000);
    }

    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
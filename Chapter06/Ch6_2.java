import io.reactivex.Observable;

        import java.util.concurrent.ThreadLocalRandom;

public class Ch6_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma")
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        Observable.range(1, 3)
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
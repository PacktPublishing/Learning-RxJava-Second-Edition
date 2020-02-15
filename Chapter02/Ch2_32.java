import io.reactivex.rxjava3.core.Completable;

public class Ch2_32 {
    public static void main(String[] args) {
        Completable.fromRunnable(() -> runProcess())
                .subscribe(() -> System.out.println("Done!"));
    }

    private static void runProcess() {
       //run process here
    }
}
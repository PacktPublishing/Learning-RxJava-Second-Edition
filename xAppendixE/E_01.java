import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class E_01 {
    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.computation();

        //run task now
        scheduler.scheduleDirect(() -> System.out.println("Now!"));

        //delay task by 1 second
        scheduler.scheduleDirect(() ->
                System.out.println("Delayed!"), 1, TimeUnit.SECONDS);

        //repeat task every second
        scheduler.schedulePeriodicallyDirect(() ->
                System.out.println("Repeat!"), 0, 1, TimeUnit.SECONDS);

        //keep alive for 5 seconds
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class E_02 {
    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.computation();
        Scheduler.Worker worker = scheduler.createWorker();

        //run task now
        worker.schedule(() -> System.out.println("Now!"));

        //delay task by 1 second
        worker.schedule(() -> System.out.println("Delayed!"), 1,
                TimeUnit.SECONDS);

        //repeat task every second
        worker.schedulePeriodically(() ->
                System.out.println("Repeat!"), 0, 1, TimeUnit.SECONDS);

        //keep alive for 5 seconds, then dispose Worker
        sleep(5000);
        worker.dispose();
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

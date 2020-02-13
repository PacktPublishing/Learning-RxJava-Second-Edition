import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.TimeUnit;

public class Ch10_12 {
    @Test
    public void usingTestObserver() {
        //An Observable with 5 one-second emissions
        Observable<Long> source =
                Observable.interval(1, TimeUnit.SECONDS)
                          .take(3);

        //Declare TestObserver
        TestObserver<Long> testObserver = new TestObserver<>();

        //Assert no subscription has occurred yet
        //testObserver.assertNotSubscribed();
        assertFalse(testObserver.hasSubscription());

        //Subscribe TestObserver to source
        source.subscribe(testObserver);

        //Assert TestObserver is subscribed
        testObserver.hasSubscription();

        //Block and wait for Observable to terminate
        //testObserver.awaitTerminalEvent();
        try {
            testObserver.await(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Assert TestObserver called onComplete()
        testObserver.assertComplete();

        //Assert there were no errors
        testObserver.assertNoErrors();

        //Assert 5 values were received
        testObserver.assertValueCount(3);

        //Assert the received emissions were 0, 1, 2, 3, 4
        testObserver.assertValues(0L, 1L, 2L);
    }
}

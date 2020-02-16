import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Ch10_06 {
    @Test
    public void testLast() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        String lastLengthFour =
                source.filter(s -> s.length() == 4)
                      .blockingLast();

        assertTrue(lastLengthFour.equals("Zeta"));
    }
}

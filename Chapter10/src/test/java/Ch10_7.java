import io.reactivex.Observable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Ch10_7 {
    @Test
    public void testIterable() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        Iterable<String> allLengthFive =
                source.filter(s -> s.length() == 5)
                      .blockingIterable();

        for (String s: allLengthFive) {
            assertTrue(s.length() == 5);
        }
    }
}

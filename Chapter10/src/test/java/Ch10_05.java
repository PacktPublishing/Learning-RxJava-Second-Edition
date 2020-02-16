import io.reactivex.rxjava3.core.Observable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class Ch10_05 {
    @Test
    public void testSingle() {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Zeta");

        List<String> allLengthFour =
                source.filter(s -> s.length() == 4)
                      .toList()
                      .blockingGet();

        assertTrue(allLengthFour.equals(Arrays.asList("Beta","Zeta")));
    }
}

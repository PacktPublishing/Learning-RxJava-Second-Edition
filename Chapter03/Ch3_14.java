import io.reactivex.rxjava3.core.Observable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ch3_14 {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
        Observable.just("1/3/2016", "5/9/2016", "10/12/2016")
                .map(s -> LocalDate.parse(s, dtf))
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}
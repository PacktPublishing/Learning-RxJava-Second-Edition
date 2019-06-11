import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class Ch9_1a {
    public static void main(String[] args) {

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(System.out::println);

        Observable.range(1,10)
                .collect(ImmutableList::builder, ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(System.out::println);
    }
}
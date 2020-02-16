import io.reactivex.rxjava3.core.Observable;

public class Ch4_06 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("521934/2342/FOXTROT", "21962/12112/TANGO/78886");
        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+")) //use regex to filter integers
                .map(Integer::valueOf)
                .subscribe(System.out::println);
    }
}
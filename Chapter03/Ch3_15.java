import io.reactivex.rxjava3.core.Observable;

public class Ch3_15 {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
       //print menu
        menu.startWithItem("COFFEE SHOP MENU")
                .subscribe(System.out::println);
    }
}
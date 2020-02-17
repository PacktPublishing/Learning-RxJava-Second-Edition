import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class A_07 {
    public static void main(String[] args) {
        Supplier<List<String>> listGenerator = ArrayList::new;
        List<String> myList = listGenerator.get();
    }
}

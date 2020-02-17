import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class A_06 {
    public static void main(String[] args) {
        Supplier<List<String>> listGenerator = () -> new ArrayList<>();
        List<String> myList = listGenerator.get();    }
}

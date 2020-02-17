import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class A_05 {
    public static void main(String[] args) {
        Supplier<List<String>> listGenerator =
                new Supplier<List<String>>() {
                    @Override
                    public List<String> get() {
                        return new ArrayList<>();
                    }
                };
        List<String> myList = listGenerator.get();
    }
}

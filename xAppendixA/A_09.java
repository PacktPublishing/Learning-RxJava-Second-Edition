import java.util.function.Consumer;

public class A_09 {
    public static void main(String[] args) {
        Consumer<String> printConsumer =
                (String s) -> System.out.println(s);
        printConsumer.accept("Hello World");
    }
}

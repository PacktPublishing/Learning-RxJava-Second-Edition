import java.util.function.Function;

public class A_13 {
    public static void main(String[] args) {
        Function<String,Integer> lengthMapper = (String s) -> s.length();
        Integer length = lengthMapper.apply("Alpha");
        System.out.println(length);
    }
}

import java.util.function.Function;

public class A_12 {
    public static void main(String[] args) {
        Function<String,Integer> lengthMapper =
                new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                };
        Integer length = lengthMapper.apply("Alpha");
        System.out.println(length);
    }
}

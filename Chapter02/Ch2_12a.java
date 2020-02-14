import org.davidmoten.rx.jdbc.Database;

public class Ch2_12a {
    public static void main(String[] args) {
        Database db = Database.test();
        db.select("select name from person")
                .getAs(String.class)
                .blockingForEach(System.out::println);
    }
}

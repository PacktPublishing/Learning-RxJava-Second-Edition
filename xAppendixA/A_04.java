public class A_04 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("Message 1");
            System.out.println("Message 2");
        };
        runnable.run();
    }
}

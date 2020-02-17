public class A_02 {
    public static void main(String[] args) {
        Runnable runnable = () -> System.out.println("run() was called!");
        runnable.run();
    }
}

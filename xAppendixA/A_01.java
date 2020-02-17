public class A_01 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("run() was called!");
            }
        };
        runnable.run();
    }
}

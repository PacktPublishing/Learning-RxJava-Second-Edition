public class A_03 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Message 1");
                System.out.println("Message 2");
            }
        };
        runnable.run();
    }
}

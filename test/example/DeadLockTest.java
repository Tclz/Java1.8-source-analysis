package example;

public class DeadLockTest {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(()->{
            synchronized (A){
                System.out.println("AAA has obtained lock A");
                try {
                    Thread.sleep(500);
                    System.out.println("AAA try to get lock B...");
                    synchronized (B){

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AAA").start();

        new Thread(()->{
            synchronized (B){
                System.out.println("BBB has obtained lock B");
                try {
                    Thread.sleep(500);
                    System.out.println("BBB try to get lock A...");
                    synchronized (A){

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}

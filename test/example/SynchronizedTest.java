package example;

public class SynchronizedTest {
    public static void main(String[] args) {
//        method();
        method2();
    }
    //javap -c -s -v -l xxx.class
    public static synchronized void method() {
        System.out.println("synchronized 方法");
    }
    public static void method2(){
        synchronized (SynchronizedTest.class){
            System.out.println("xxx");
        }
    }
}

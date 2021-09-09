package example;

public class TryCatchTest {
    public static int printX() {
        System.out.println("X");
        return 0;
    }
    public static void main(String[] args) {
        int x = 1;
        assert x > 0;
        System.out.println(x);
        int i=0;
            try {
                printX();
                i = 2;
                System.out.println(i);
                return;
            }
            finally {
                System.out.println("finally trumps return... sort of");
                i = 3;
                System.out.println(i);
                return;
            }
        }

    }


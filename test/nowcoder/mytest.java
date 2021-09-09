package nowcoder;

import java.util.*;
public class mytest{
    public static void main(String[] args){
        double[] a = {3.0, 4.0};
        Vector vector = new Vector(a);
        vector.printValue();
        a[0] = 0.0;
        vector.printValue();
        final int[] b = {1,2};
        int[] c = b;
        c[0] = 5;
        System.out.println(b[0]);
        System.out.println(c[0]);
        String str1 = new String("123");
        String str2 = new String("123");
        System.out.println(str1==str2);
        System.out.println(str2.equals(str1));
    }
}
class Vector{
    private final double[] coords;
    public Vector(double[] a){
        coords = a;
    }
    public void printValue(){
        for(double t : coords){
            System.out.println(t);
        }
    }
}


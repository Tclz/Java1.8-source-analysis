package nowcoder;
import java.util.*;
public class JD11 {
        public static void main(String[] args){
            String s = new Scanner(System.in).nextLine();
            for(int i=0;i<s.length();++i){
                if(check(s.substring(i))){
                    System.out.println(i+s.length());
                    break;
                }
            }

        }
        public static boolean check(String x){
            StringBuffer sb = new StringBuffer(x);
            return x.equals(sb.reverse().toString());
        }
    }


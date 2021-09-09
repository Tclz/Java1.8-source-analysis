package nowcoder;
import java.util.*;
public class KS34 {
        public static void main(String[] args){
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            List<String> res = ParseStr(s);
            int ans = getValue(res);
            System.out.println(ans);
        }
        private static List<String>ParseStr(String s){
            Stack<String>stack = new Stack<>();
            ArrayList<String>list = new ArrayList<>();
            for(int i=0;i<s.length();++i){
                String tmp = String.valueOf(s.charAt(i));
                switch(tmp){
                    case "+":
                    case "-":
                        while(!stack.empty()&& !stack.peek().equals("("))
                            list.add(stack.pop());
                        stack.push(tmp);
                        break;
                    case "*":
                    case "/":
                        while(!stack.empty()&& (stack.peek().equals("*")||stack.peek().equals("/")))
                            list.add(stack.pop());
                        stack.push(tmp);
                        break;
                    case "(":
                        stack.push(tmp);
                        break;
                    case ")":
                        while(!stack.empty()&& !stack.peek().equals("("))
                            list.add(stack.pop());
                        stack.pop();
                        break;

                    // 数字
                    default:
                        int sum = Integer.parseInt(tmp);
                        while(i+1<s.length()&&s.charAt(i+1)<='9'&&s.charAt(i+1)>='0')
                        {
                            sum = sum * 10 + (s.charAt(i+1)-'0');
                            ++i;
                        }
                        list.add(String.valueOf(sum));
                }
                System.out.println(stack);
            }
            while(!stack.empty())
                list.add(stack.pop());
            return list;
        }
        private static int getValue(List<String>list){
            Stack<Integer>stack = new Stack<>();
            for(String s:list){
                switch(s){
                    case "+":
                        stack.push(stack.pop()+stack.pop());
                        break;
                    case "-":
                        int b = stack.pop();
                        int a = stack.pop();
                        stack.push(a-b);
                        break;
                    case "*":
                        stack.push(stack.pop()*stack.pop());
                        break;
                    case "/":
                        int b1 = stack.pop();
                        int a1 = stack.pop();
                        stack.push(a1/b1);
                        break;
                    default:
                        stack.push(Integer.parseInt(s));

                }
            }
            return stack.pop();
        }

}
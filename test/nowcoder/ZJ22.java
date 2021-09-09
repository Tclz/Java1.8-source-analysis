package nowcoder;
import java.util.*;
public class ZJ22 {
        public static void main(String[] args){
            Scanner scan  = new Scanner(System.in);
            int n = scan.nextInt();
            int M = 1<<(n-1);
            int[][] dp = new int[n][M];
            int[][] map = new int[n][n];
            for(int i=0;i<n;++i)
                for(int j=0;j<n;++j){
                    map[i][j] = scan.nextInt();
                }
            // 集合为空时 直接是计算该点到到0号城市的距离
            for(int i=1;i<n;++i)
                dp[i][0] = map[i][0];
            // 自底向上 从小集合算起
            for(int j=1;j<M;++j){
                for(int i=0;i<n;++i){
                    // 第i号城市已然在集合中 如dp[1][1,2] 不符
                    if(i>0 && ((j>>(i-1))&1)==1)
                        continue;
                    // 穷举所有情况
                    dp[i][j] = Integer.MAX_VALUE;
                    for(int k=1;k<n;++k){
                        //k没有在集合中 则无法选中它用来跳转
                        if(((j>>(k-1))&1)==0)
                            continue;
                        // 提取k城市 转移到代价更小的路线中
                        dp[i][j] = Math.min(dp[i][j],map[i][k]+dp[k][j^(1<<(k-1))]);
                    }
                }
            }
            System.out.println(dp[0][M-1]);
        }

}

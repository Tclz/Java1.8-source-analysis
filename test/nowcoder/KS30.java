package nowcoder;

import java.util.*;
import java.lang.*;
class Edge implements Comparable{
    int u,v,w;
    public Edge(int u,int v,int w){
        this.u = u;
        this.v = v;
        this.w = w;
    }
    @Override
    public int compareTo(Object o){
        Edge e = (Edge)o;
        return this.w-e.w;
    }
}
public class KS30 {
    private static Map<Integer,Integer>map = new HashMap<>();
    private static int[] father;
    public static void main(String[] args){
        int t,n,m;
        Scanner scan = new Scanner(System.in);
        t = Integer.parseInt(scan.nextLine());
        while(t-->0){
            map.clear();
            String line = scan.nextLine();
            String[] list = line.split(" ");
            n = Integer.parseInt(list[0]);
            m = Integer.parseInt(list[1]);
//            System.out.println(n);
//            System.out.println(m);
            List<Edge>edges = new ArrayList<>();
            for(int i=1;i<=n;++i){
                int dis = scan.nextInt();
                edges.add(new Edge(0,i,dis));
            }
            String ss = scan.nextLine();
            for(int i=1;i<=m;++i){
                String strs = scan.nextLine();
                String[] str = strs.split(" ");
                edges.add(new Edge(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
            }
            Collections.sort(edges);
//            for(Edge e:edges)
//                System.out.println(e.w);
            father = new int[n+1];
            for(int i=0;i<=n;++i)
            {
                father[i] = i;
                map.put(i,1);
            }
            int cnt = 0;
            int ans = 0;
            for(Edge edge:edges){
                if(cnt>=n)
                    break;
                if(Union(edge.u,edge.v)){
                    cnt++;
                    ans+=edge.w;
                }
            }
            System.out.println(ans);
        }
    }
    private static int find(int x){
        int t = x;
        while(x!= father[x])
            x = father[x];
        // 路径压缩
        while(t!=x){
            int a = father[t];
            father[t] = x;
            t = a;
        }
        return x;
    }
    private static Boolean Union(int x,int y){
        int fa_x = find(x);
        int fa_y = find(y);
        if(fa_x!=fa_y)
        {
            int rank_x = map.get(fa_x);
            int rank_y = map.get(fa_y);
            int big = rank_x>rank_y ? fa_x:fa_y;
            int small = big==fa_x ? fa_y:fa_x;
            father[small] = big;
            map.put(big,map.get(fa_y)+map.get(fa_x));
            map.remove(small);
            return true;
        }
        return false;
    }

}

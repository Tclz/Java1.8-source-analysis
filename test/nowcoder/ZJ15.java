package nowcoder;
import java.util.*;
public class ZJ15{
    public static void main(String[] args){
        int n,m,p;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        p = scan.nextInt();
        String s = scan.nextLine();
        int idx = 1;
        int pm,occur,priori,cost;
        ArrayList<Task> array = new ArrayList<>();
        for(int i=0;i<p;++i){
            String[] line = scan.nextLine().split(" ");
            pm = Integer.parseInt(line[0]);
            occur = Integer.parseInt(line[1]);
            priori = Integer.parseInt(line[2]);
            cost = Integer.parseInt(line[3]);
            array.add(new Task(idx++,pm,occur,priori,cost));
        }
        PriorityQueue<Task>[] pq = new PriorityQueue[n+1];
        int[] busy = new int[m];
        int[] ans = new int[p+1];
        int time = 0;
        while(p>0){
            ++time;
            for(int i=0;i<m;++i){
                if(busy[i]>0){
                    busy[i] -= 1;
                }
            }
            for(int i=0;i<array.size();++i){
                if(array.get(i).occur==time){
                    int p_id = array.get(i).pm;
                    if(pq[p_id]==null)
                        pq[p_id] = new PriorityQueue<Task>();
                    pq[p_id].offer(array.get(i));
                }
            }
            for(int i=0;i<m;++i){
                if(busy[i]==0){
                    if(p>0){
                        --p;
                        int fee = Integer.MAX_VALUE;
                        int pm_idx = Integer.MAX_VALUE;
                        for(int j=1;j<pq.length;++j){
                            if(pq[j]!=null && !pq[j].isEmpty()){
                                Task t = pq[j].peek();
                                if(t.cost<=fee){
                                    fee = t.cost;
                                    if(t.pm<pm_idx)
                                        pm_idx = t.pm;
                                }
                            }
                        }
                        Task tmp = pq[pm_idx].poll();
                        ans[tmp.id] = time + tmp.cost;
                        busy[i] = tmp.cost;

                    }

                }
                else break;
            }
        }


        for(int i=1;i<ans.length;++i)
            System.out.println(ans[i]);
    }
    static class Task implements Comparable{
        public int id,pm,occur,priori,cost;
        public Task(int id,int pm,int occur,int priori,int cost){
            this.id = id;
            this.pm = pm;
            this.occur = occur;
            this.priori = priori;
            this.cost = cost;
        }
        @Override
        public int compareTo(Object o){
            Task t = (Task)o;
            if(this.priori!=t.priori)
                return t.priori-this.priori;
            else if(this.cost!=t.cost)
                return this.cost-t.cost;
            return this.occur-t.occur;

        }
    }
}
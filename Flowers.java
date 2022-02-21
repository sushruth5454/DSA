import java.util.ArrayList;
import java.util.Scanner;

public class Flowers {
    static final int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=sc.nextInt();
        //int len=0;
        //ArrayList<ArrayList<Integer>>query=new ArrayList<>()
        long []dp=new long[100005];
        dp[0]=1;
        if(k>1)
            dp[1]=1;
        else
            dp[1]=2;
        for(int i=2;i<100005;i++){
            if(i<k)
                dp[i]=dp[i-1]%mod;
            else
                dp[i]=(dp[i-1]%mod+dp[i-k]%mod)%mod;
        }
        for(int i=1;i<=100000;i++)
            dp[i]=(dp[i-1]%mod+dp[i]%mod)%mod;
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            //len=Math.max(len,b);
            System.out.println((dp[b]-dp[a-1]+mod)%mod);
        }
        /*long []prefix=new long[100005];
        prefix[0]=0;
        long p=dp[0];
        for(int i=1;i<100005;i++){
            prefix[i]=p%mod;
            p+=dp[i]%mod;
        }
        ArrayList<Long>result=new ArrayList<>();
        for(int i=0;i<query.size();i++){
            int a=query.get(i).get(0);
            int b=query.get(i).get(1);
            result.add((prefix[b]%mod)-(prefix[a]%mod)+(dp[b]%mod));
        }
        for(long i:result)
            System.out.println(i);
        return;*/
    }
}

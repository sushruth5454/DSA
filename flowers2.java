import java.util.Scanner;

public class flowers2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long []dp=new long[100005];
        dp[0]=1;
        int t=sc.nextInt();
        int k=sc.nextInt();
        if(k==1)
            dp[1]=2;
        else
            dp[1]=1;
        for(int i=2;i<=100000;i++){
            dp[i]=dp[i-1];
            if(i-k>=0)
                dp[i]+=dp[i-k];
        }
        for(int i=1;i<=10000;i++)
            dp[i]+=dp[i-1];
        for(int i=0;i<t;i++){
            int a=sc.nextInt();
            int b= sc.nextInt();
        }
    }
}

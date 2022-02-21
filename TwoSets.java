import java.util.Scanner;

public class TwoSets {
    static final int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=(n*(n+1))/2;
        if(sum%2!=0)
            System.out.println(0);
        else{
            int rsum=sum/2;
            long [][]dp=new long[n+1][rsum+1];
            //dp[0][0]=0;
            for(int i=0;i<=n;i++)
                if(i>0)
                    dp[i][0]=1;
            for(int j=1;j<=rsum;j++){
                for(int i=1;i<=n;i++){
                    dp[i][j]=(dp[i-1][j]%mod)+((i<=j) ? (dp[i-1][j-i]%mod) :0);
                }
            }
            System.out.println(dp[n][rsum]%mod);
            /*for(int i=0;i<=n;i++){
                for(int j=0;j<=rsum;j++){
                    System.out.print(dp[i][j]+" ");
                }
                System.out.println();
            }*/
        }
        return;
    }
}

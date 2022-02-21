import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class KnapSack2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int w=sc.nextInt();
        int []wt=new int[n];
        int []val=new int[n];
        //int sum=0;
        for(int i=0;i<n;i++){
            wt[i]=sc.nextInt();
            val[i]=sc.nextInt();
            //sum+=val[i];
        }
        int [][]dp=new int[n][100001];
        for(int []u:dp)
            Arrays.fill(u,Integer.MAX_VALUE);
        int max_profit=0;
        dp[0][val[0]]=wt[0];
        for(int i=0;i<n;i++)
            dp[i][0]=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<=100000;j++){
                if(val[i]<=j){
                    dp[i][j]=Math.min(dp[i-1][j],(dp[i-1][j-val[i]]!=Integer.MAX_VALUE ? wt[i]+dp[i-1][j-val[i]] :Integer.MAX_VALUE));
                }
                else
                    dp[i][j]=dp[i-1][j];
                if(dp[i][j]<=w){
                    max_profit=Math.max(max_profit,j);
                }
            }
        }
        /*for(int i=0;i<n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.println(max_profit);

    }
}

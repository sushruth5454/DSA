import java.util.Arrays;
import java.util.Scanner;

public class Frog1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int []dp=new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[n-1]=0;
        //dp[n-2]=Math.abs(arr[n-2]-arr[n-1]);
        for(int i=n-2;i>=0;i--) {
            for (int j = 1; j <= k; j++) {
                if (i + j < n)
                    dp[i] = Math.min(dp[i], Math.abs(arr[i + j] - arr[i]) + dp[i + j]);
            }
        }
        System.out.println(dp[0]);
    }
}

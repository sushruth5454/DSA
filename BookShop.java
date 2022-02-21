import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BookShop {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int x=sc.nextInt();
        int []price=new int[n];
        int [][]dp=new int[n+1][x+1];
        for(int i=0;i<n;i++)
            price[i]=sc.nextInt();
        int []pages=new int[n];
        for(int i=0;i<n;i++) {
            pages[i] = sc.nextInt();
            //dp[price[i]] = Math.max(dp[price[i]],pages[i]);
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=x;j++){
                if(price[i-1]>j)
                    dp[i][j]=dp[i-1][j];
                else
                    dp[i][j]=Math.max(dp[i-1][j],pages[i-1]+dp[i-1][j-price[i-1]]);
            }
        }
        System.out.println(dp[n][x]);
        /*dp[0]=0;
        Arrays.sort(price);
        for(int i=0;i<=x;i++) {
            //int j = price[i];
            for(int p=0;p<=x;p++){
                System.out.print(dp[p]+" ");
            }
            System.out.println();
            for (int k = 0; k <n; k++) {
                int j = price[k];
                if (i < j || i - j == j)
                    continue;
                dp[i] = Math.max(dp[i], dp[i - j] + dp[j]);
                *//*if (k == 10) {
                    System.out.println(dp[k] + " j= " +j+" "+ dp[j] + " " + dp[k - j]);
                    System.out.println(dp[k]);
                }*//*
            }
        }
        for(int i=0;i<=x;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.println(dp[x]);
        return;*/


    }
}

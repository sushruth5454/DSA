import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.zip.DeflaterInputStream;

public class ReducetoZero {
    public static ArrayList<Integer> getDigits(int n){
        ArrayList<Integer>digits=new ArrayList<>();
        while (n!=0){
            if(n%10!=0)
                digits.add(n%10);
            n=n/10;
        }
        return digits;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n &&i<=9;i++)
            dp[i]=1;
        for(int i=10;i<=n;i++){
            ArrayList<Integer>digits=getDigits(i);
            for(int k:digits){
                dp[i]=Math.min(dp[i],1+dp[i-k]);
            }
        }
        System.out.println(dp[n]);


    }
}

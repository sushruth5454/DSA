import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long []dp=new long[1000000001];
        for(int i=0;i<10;i++)
            dp[i]=i;
        for(int i=10;i<=1000000000;i++){
            dp[i]=dp[i/10]+dp[i%10];
        }
        for(int i=1;i<=1000000000;i++){
            dp[i]+=dp[i-1];
        }
        while (true){
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a==-1 && b==-1)
                break;
            System.out.println((b>=0 ? dp[b] :0)-(a>0 ? dp[a-1] : 0));
        }
    }
}

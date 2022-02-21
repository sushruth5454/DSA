import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class ArrayDescription {
    static final int mod=1000000007;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        long [][]dp=new long[m+1][n];
        for(int j=0;j<n;j++){
            if(j==0){
                if(arr[j]!=0)
                    dp[arr[j]][j]=1;
                else{
                    for(int i=1;i<=m;i++)
                        dp[i][j]=1;
                }
                continue;
            }
            if(arr[j]==0){
                for(int i=1;i<=m;i++){
                    //System.out.println(i);
                    dp[i][j]=dp[i][j-1]%mod+ dp[i-1][j-1]%mod+ (i<m ? dp[i+1][j-1]%mod :0);
                }
            }
            else{
                dp[arr[j]][j]=dp[arr[j]][j-1]%mod +dp[arr[j]-1][j-1]%mod +(arr[j]<m ?dp[arr[j]+1][j-1]%mod :0);
            }
        }
        long ans=0;
        /*for(int i=0;i<=m;i++){
            for(int j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }*/
        for(int i=0;i<=m;i++)
            ans+=dp[i][n-1]%mod;
        System.out.println(ans%mod);
        return;
    }
}

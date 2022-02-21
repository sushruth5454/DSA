import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ScatterPalin {
    public static boolean isPalin(int []count){
        boolean odd=false;
        for(int i=0;i<count.length;i++){
            if(count[i]%2!=0){
                if(!odd)
                    odd=true;
                else
                    return false;
            }
        }
        return true;
    }
    public static int scatter(String s){
        int []count=new int[256];
        int ans=0;
        int n=s.length();
        for(int i=0;i<n-1;i++){
            count=new int[256];
            ans+=1;
            count[s.charAt(i)]=1;
            for(int j=i+1;j<n;j++){
                count[s.charAt(i)]+=1;
                if(isPalin(count))
                    ans+=1;
            }
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int ans=scatter(s);
        System.out.println(ans);


    }
}

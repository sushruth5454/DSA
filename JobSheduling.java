import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
class job{
    int s,f,p;
    job(int s,int f,int p){
        this.s=s;
        this.f=f;
        this.p=p;
    }
}
public class JobSheduling {
    public static int binarySearch(job[] jobs,int i){
        int start=0;
        int end=i-1;
        while(start<=end){
            int mid=start+((end-start)/2);
            if(jobs[mid].f<jobs[i].s){
                if(jobs[mid+1].f<jobs[i].s)
                    start=mid+1;
                else
                    return mid;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        job []jobs=new job[n];
        for(int i=0;i<n;i++){
            int s=sc.nextInt();
            int f=sc.nextInt();
            int p=sc.nextInt();
            jobs[i]=new job(s,f,p);
        }
        Arrays.sort(jobs,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                job j1=(job)(o1);
                job j2=(job)(o2);
                return Integer.compare(j1.f,j2.f);
            }
        });
        int []dp=new int[n];
        dp[0]=jobs[0].p;
        for(int i=1;i<n;i++){
            int incl=jobs[i].p;
            int idx=binarySearch(jobs,i);
            if(idx!=-1){
                incl+=dp[idx];
            }
            int excl=dp[i-1];
            //System.out.println(incl+" "+excl+" "+idx);
            dp[i]=Math.max(incl,excl);
        }
        /*for(int i=0;i<n;i++)
            System.out.print(dp[i]+" ");*/
        System.out.println(dp[n-1]);

    }
}

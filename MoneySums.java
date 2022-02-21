import java.util.*;

public class MoneySums {
    /*static ArrayList<Integer>result;
    public static void find(int []arr,int sum,int index,int n){
        for(int i=index;i<n;i++){
            if(i>index && arr[i]==arr[index])
                continue;
            result.add(sum+arr[i]);
            find(arr,sum+arr[i],i+1,n);
        }
    }*/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int []arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Set<Integer>res=new HashSet<>();
        res.add(arr[0]);
        for(int i=1;i<n;i++)
        {
            ArrayList<Integer>t=new ArrayList<>(res);
            for(int k:t)
                res.add(k+arr[i]);
            res.add(arr[i]);
        }
        ArrayList<Integer>result=new ArrayList<>(res);
        Collections.sort(result);
        System.out.println(result.size());
        for(int i=0;i<result.size();i++)
            System.out.print(result.get(i)+" ");
        System.out.println();
        return;


    }
}

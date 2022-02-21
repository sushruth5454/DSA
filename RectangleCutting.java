import java.util.Scanner;

public class RectangleCutting {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=0;
        while (a!=b){
            if(a>b)
                a=a-b;
            else
                b=b-a;
            count++;
        }
        System.out.println(count);
    }
}

import java.util.*;
public class Main3{
    public static int 1cm(int m,int n){
        return (m*n)/gcd(m,d);
    }
    public static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
    public static void main(String[] args){
        Scanner in=new Scnaner(system.in);
        int a=in.nextInt();
        int b=in.nextInt();
        System.out.println(1cm(a,b));
    }
}

import java.util.Scanner;
//从键盘任意输入十个数字，求和。
public class Sum {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int sum=0;
        int[] a=new int[10];
        System.out.print("请输入十个数字：");
        for(int i=0;i<a.length;i++){
            a[i]=scan.nextInt();
            sum+=a[i];
        }
        System.out.println("sum="+sum);
    }
}
